package com.programmergabut.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.model.json.npmovie.Result
import com.programmergabut.moviecatalogue.ui.detail.DetailActivity
import com.programmergabut.moviecatalogue.utils.EnumConfig
import kotlinx.android.synthetic.main.layout_movie.view.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.FilmViewHolder>() {

    private var listData = mutableListOf<Result>()

    fun setData(datas: List<Result>){
        listData.clear()
        listData.addAll(datas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    inner class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Result){
            itemView.apply{

                tv_movie_title.text = movie.title
                tv_movie_overview.text = if(movie.overview.length > 150) movie.overview.substring(0,150) else movie.overview

                Glide.with(context)
                    .load(movie.posterPath) //karena image terlalu besar, glide menjadi lama untuk load datanya
                    .centerCrop()
                    .into(iv_movie)

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.dataID, movie.id)
                        putExtra(DetailActivity.dataType, EnumConfig.typeMovie)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

}