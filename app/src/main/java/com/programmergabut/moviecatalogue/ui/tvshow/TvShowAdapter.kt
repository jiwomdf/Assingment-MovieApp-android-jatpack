package com.programmergabut.moviecatalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result
import com.programmergabut.moviecatalogue.ui.detailTvShow.DetailTvShowActivity
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
                    .load(EnumConfig.imgBaseUrl + tvShow.backdropPath)
                    .centerCrop()
                    .into(iv_tvshow)

                val b = initBundle(tvShow.id, tvShow.name,
                    tvShow.firstAirDate, tvShow.overview, tvShow.voteCount,
                    tvShow.posterPath, tvShow.genreIds as ArrayList<Int>)

                setOnClickListener {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.bundleMovieDetail, b)
                    }
                    context.startActivity(intent)
                }
            }
        }

        private fun initBundle(
            tvShowID: Int,
            tvShowTitle: String,
            tvShowReleaseDate: String,
            tvShowOverview: String,
            tvShowVoteCount: Int,
            tvShowImageUrl: String,
            tvShowGenreID: ArrayList<Int>
        ): Bundle {
            val bundle = Bundle()
            bundle.putInt("tvShow_id", tvShowID)
            bundle.putString("tvShow_title", tvShowTitle)
            bundle.putString("tvShow_releaseDate", tvShowReleaseDate)
            bundle.putString("tvShow_overview", tvShowOverview)
            bundle.putInt("tvShow_voteCount", tvShowVoteCount)
            bundle.putString("tvShow_imgUrl", tvShowImageUrl)
            bundle.putIntegerArrayList("tvShow_genreId", tvShowGenreID)

            return bundle
        }
    }



}
