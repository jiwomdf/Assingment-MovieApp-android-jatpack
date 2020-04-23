package com.programmergabut.moviecatalogue.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.ui.movie.MovieFragment
import com.programmergabut.moviecatalogue.ui.tvshow.TvShowFragment

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getItem(position: Int): Fragment{
        return when(position){
            0 -> MovieFragment()
            else -> TvShowFragment()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])
}