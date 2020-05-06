package com.programmergabut.moviecatalogue.ui.detailMovie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.model.json.genre.Genre
import com.programmergabut.moviecatalogue.utils.EnumStatus
import com.programmergabut.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val bundleMovieDetail = "bundle_movie_detail"
    }

    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private var movieID: Int? = null
    private var movieTitle: String? = null
    private var movieReleaseDate: String? = null
    private var movieOverview: String? = null
    private var movieVoteCount: Int? = null
    private var movieGenreID: ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        detailMovieViewModel= ViewModelProvider(this, ViewModelFactory.getInstance())[DetailMovieViewModel::class.java]

        initVariable()

        observeApi()
        fetchApi()

        bindView()
    }

    private fun fetchApi() {
        detailMovieViewModel.genre()
    }

    private fun genreFilter(listGenre: List<Genre>): List<Genre> {

        val retList = mutableListOf<Genre>()

        movieGenreID?.forEach {x ->
            listGenre.forEach { y ->
                if(y.id == x)
                    retList.add(y)
            }
        }

        return retList
    }

    private fun genreMaker(listGenre: List<Genre>): String {
        var strGenre = ""
        listGenre.forEachIndexed {idx, x ->
            if(idx == listGenre.size - 1)
                strGenre += x.name
            else
                strGenre += "${x.name}, "
        }

        return strGenre
    }

    private fun observeApi() {
        detailMovieViewModel.genre().observe(this, Observer {
            when(it.Status){
                EnumStatus.SUCCESS -> {
                    if(it.data?.genres == null)
                        throw Exception("null genres")

                    bindGenre(it.data.genres)
                }
                EnumStatus.LOADING -> pb_detail_genre.visibility = View.VISIBLE
                EnumStatus.ERROR -> {
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                    pb_detail_genre.visibility = View.GONE
                }
            }
        })
    }

    private fun bindGenre(it: List<Genre>) {
        pb_detail_genre.visibility = View.GONE
        tv_detail_genre_movie.visibility = View.VISIBLE

        val listGenre = genreFilter(it)
        val strGenre = genreMaker(listGenre)
        tv_detail_genre_movie.text = strGenre
    }

    private fun initVariable() {
        if(intent?.extras == null)
            throw Exception("null extras")

        val bundle = intent.extras!!.getBundle(bundleMovieDetail)
        val isSuccess = deserializeBundle(bundle)

        if(!isSuccess)
            throw Exception("failed deserialize bundle")
    }

    private fun bindView() {
        Glide.with(this)
            .load("https://geo0.ggpht.com/cbk?panoid=dwnQ4AmNaeQTwcWAiAPbSw&output=thumbnail&cb_client=search.gws-prod.gps&thumb=2&yaw=141.86023&pitch=0&thumbfov=100&w=227&h=160") //karena image terlalu besar, glide menjadi lama untuk load datanya
            .centerCrop()
            .into(iv_detail_movie)

        tv_detail_ect_movie.text = "Release Date : $movieReleaseDate"
        tv_detail_title_movie.text = movieTitle
        tv_detail_overview_movie.text = movieOverview
        tv_detail_score_movie.text = "Vote Count : $movieVoteCount"
        //tv_detail_genere.text = movieGenreID?.get(0).toString()
    }

    private fun deserializeBundle(bundle: Bundle?): Boolean {

        return try{
            movieID = bundle?.getInt("movie_id")
            movieTitle = bundle?.getString("movie_title")
            movieReleaseDate = bundle?.getString("movie_releaseDate")
            movieOverview = bundle?.getString("movie_overview")
            movieVoteCount = bundle?.getInt("movie_voteCount")
            movieGenreID = bundle?.getIntegerArrayList("movie_genreId")

            true
        } catch(ex: Exception){
            false
        }
    }
}
