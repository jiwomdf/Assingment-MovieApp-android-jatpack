package com.programmergabut.moviecatalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.Result
import com.programmergabut.moviecatalogue.ui.detailMovie.DetailMovieActivity
import com.programmergabut.moviecatalogue.utils.EnumConfig
import kotlinx.android.synthetic.main.layout_movie.view.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieAdapter : PagedListAdapter<Result,MovieAdapter.FilmViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {

        val movie = getItem(position)
        if (movie != null)
            holder.bind(movie)
    }

    inner class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Result){
            itemView.apply{

                tv_movie_title.text = movie.title
                tv_movie_overview.text = if(movie.overview.length > 150) movie.overview.substring(0,150) else movie.overview

                Glide.with(context)
                    .load(EnumConfig.imgBaseUrl + movie.posterPath)
                    .centerCrop()
                    .into(iv_movie)

                setOnClickListener {

                    val b = initBundle(movie.id, movie.title,
                        movie.releaseDate, movie.overview, movie.voteCount,
                        movie.posterPath, movie.genreIds as ArrayList<Int>)

                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.bundleMovieDetail, b)
                    }
                    context.startActivity(intent)
                }
            }
        }

        private fun initBundle(
           movieID: Int,
           movieTitle: String,
           movieReleaseDate: String,
           movieOverview: String,
           movieVoteCount: Int,
           movieImgUrl: String,
           movieGenreID: ArrayList<Int>
        ): Bundle {
            val bundle = Bundle()
            bundle.putInt("movie_id", movieID)
            bundle.putString("movie_title", movieTitle)
            bundle.putString("movie_releaseDate", movieReleaseDate)
            bundle.putString("movie_overview", movieOverview)
            bundle.putInt("movie_voteCount", movieVoteCount)
            bundle.putString("movie_imgUrl", movieImgUrl)
            bundle.putIntegerArrayList("movie_genreId", movieGenreID)

            return bundle
        }
    }

}