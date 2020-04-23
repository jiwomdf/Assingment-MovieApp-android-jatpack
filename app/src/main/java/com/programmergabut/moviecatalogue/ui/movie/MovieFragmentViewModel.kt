package com.programmergabut.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.Movie
import com.programmergabut.moviecatalogue.data.TvShow
import com.programmergabut.moviecatalogue.utils.DataDummy

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragmentViewModel: ViewModel() {

    fun getMovie(): List<Movie> = DataDummy.generateMovie()
}