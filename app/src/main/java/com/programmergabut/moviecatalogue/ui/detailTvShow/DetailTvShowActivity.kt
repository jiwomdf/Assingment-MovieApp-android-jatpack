package com.programmergabut.moviecatalogue.ui.detailTvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.model.json.genre.Genre
import com.programmergabut.moviecatalogue.ui.detailMovie.DetailMovieActivity
import com.programmergabut.moviecatalogue.utils.EnumStatus
import com.programmergabut.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import java.lang.Exception

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        const val bundleMovieDetail = "bundle_movie_detail"
    }

    private lateinit var detailTvShowViewModel: DetailTvShowViewModel
    private var tvShowID: Int? = null
    private var tvShowTitle: String? = null
    private var tvShowReleaseDate: String? = null
    private var tvShowOverview: String? = null
    private var tvShowVoteCount: Int? = null
    private var tvShowGenreID: ArrayList<Int>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        detailTvShowViewModel = ViewModelProvider(this, ViewModelFactory.getInstance())[DetailTvShowViewModel::class.java]

        initVariable()

        observeApi()
        fetchApi()

        bindView()
    }

    private fun fetchApi() {
        detailTvShowViewModel.genre()
    }

    private fun genreFilter(listGenre: List<Genre>): List<Genre> {

        val retList = mutableListOf<Genre>()

        tvShowGenreID?.forEach {x ->
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
        detailTvShowViewModel.genre().observe(this, Observer {
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
        tv_detail_genre_tvShow.visibility = View.VISIBLE

        val listGenre = genreFilter(it)
        val strGenre = genreMaker(listGenre)
        tv_detail_genre_tvShow.text = strGenre
    }

    private fun initVariable() {
        if(intent?.extras == null)
            throw Exception("null extras")

        val bundle = intent.extras!!.getBundle(DetailMovieActivity.bundleMovieDetail)
        val isSuccess = deserializeBundle(bundle)

        if(!isSuccess)
            throw Exception("failed deserialize bundle")
    }

    private fun bindView() {
        Glide.with(this)
            .load("https://geo0.ggpht.com/cbk?panoid=dwnQ4AmNaeQTwcWAiAPbSw&output=thumbnail&cb_client=search.gws-prod.gps&thumb=2&yaw=141.86023&pitch=0&thumbfov=100&w=227&h=160") //karena image terlalu besar, glide menjadi lama untuk load datanya
            .centerCrop()
            .into(iv_detail_tvShow)

        tv_detail_ect_tvShow.text = "Release Date : $tvShowReleaseDate"
        tv_detail_title_tvShow.text = tvShowTitle
        tv_detail_overview_tvShow.text = tvShowOverview
        tv_detail_score_tvShow.text = "Vote Count : $tvShowVoteCount"
    }

    private fun deserializeBundle(bundle: Bundle?): Boolean {

        return try{
            tvShowID = bundle?.getInt("tvShow_id")
            tvShowTitle = bundle?.getString("tvShow_title")
            tvShowReleaseDate = bundle?.getString("tvShow_releaseDate")
            tvShowOverview = bundle?.getString("tvShow_overview")
            tvShowVoteCount = bundle?.getInt("tvShow_voteCount")
            tvShowGenreID = bundle?.getIntegerArrayList("tvShow_genreId")

            true
        } catch(ex: Exception){
            false
        }
    }

}
