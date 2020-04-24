package com.programmergabut.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.TvShow
import com.programmergabut.moviecatalogue.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.layout_movie.view.*
import kotlinx.android.synthetic.main.layout_tvshow.view.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowAdapter(private val listData: List<TvShow>): RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_tvshow, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    inner class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tvShow: TvShow) {
            itemView.apply {
                tv_tvshow_title.text = tvShow.title
                tv_tvshow_overview.text = if(tvShow.overview.length > 150) tvShow.overview.substring(0,150) else tvShow.overview
                Glide.with(context)
                    .load(tvShow.imgUrl)
                    .centerCrop()
                    .into(iv_tvshow)

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.dataID, tvShow.id)
                        putExtra(DetailActivity.dataType, tvShow.type)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

}
