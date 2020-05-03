package com.programmergabut.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result
import com.programmergabut.moviecatalogue.data.model.local.TvShow
import com.programmergabut.moviecatalogue.ui.detail.DetailActivity
import com.programmergabut.moviecatalogue.utils.EnumConfig
import kotlinx.android.synthetic.main.layout_tvshow.view.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listData = mutableListOf<Result>()

    fun setData(datas: List<Result>){
        listData.clear()
        listData.addAll(datas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_tvshow, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    inner class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tvShow: Result) {
            itemView.apply {
                tv_tvshow_title.text = tvShow.name
                tv_tvshow_overview.text = if(tvShow.overview.length > 150) tvShow.overview.substring(0,150) else tvShow.overview
                Glide.with(context)
                    .load(tvShow.backdropPath) //karena image terlalu besar, glide menjadi lama untuk load datanya
                    .centerCrop()
                    .into(iv_tvshow)

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.dataID, tvShow.id)
                        putExtra(DetailActivity.dataType, EnumConfig.typeTvShow)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

}
