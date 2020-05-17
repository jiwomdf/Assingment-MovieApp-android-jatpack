package com.programmergabut.moviecatalogue.ui.tvshow

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
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow
import com.programmergabut.moviecatalogue.ui.detailTvShow.DetailTvShowActivity
import com.programmergabut.moviecatalogue.utils.EnumConfig
import kotlinx.android.synthetic.main.layout_tvshow.view.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowAdapter: PagedListAdapter<OATvShow,TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OATvShow>() {
            override fun areItemsTheSame(oldItem: OATvShow, newItem: OATvShow): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: OATvShow, newItem: OATvShow): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_tvshow, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

        val tvShow = getItem(position)
        if (tvShow != null)
            holder.bind(tvShow)
    }

    inner class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tvShow: OATvShow) {
            itemView.apply {
                tv_tvshow_title.text = tvShow.title
                tv_tvshow_overview.text = if(tvShow.overview.length > 150) tvShow.overview.substring(0,150) else tvShow.overview

                Glide.with(context)
                    .load(EnumConfig.imgBaseUrl + tvShow.tvShowPosterUrl)
                    .centerCrop()
                    .into(iv_tvshow)

                setOnClickListener {

                    val listGenre = initListGenre(tvShow)

                    val b = initBundle(tvShow.id, tvShow.title!!,
                        tvShow.ect, tvShow.overview, tvShow.vote,
                        tvShow.tvShowPosterUrl!!, listGenre as ArrayList<Int>)


                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.bundleMovieDetail, b)
                    }
                    context.startActivity(intent)
                }
            }
        }

        private fun initListGenre(tvShow: OATvShow): MutableList<Int> {
            val clean = tvShow.genre.replace("[", "").replace("]", "")
                .replace(" ", "").trim()
            val genre = clean.split(",")
            val listGenre = mutableListOf<Int>()
            genre.forEach {
                listGenre.add(it.toInt())
            }

            return listGenre
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
