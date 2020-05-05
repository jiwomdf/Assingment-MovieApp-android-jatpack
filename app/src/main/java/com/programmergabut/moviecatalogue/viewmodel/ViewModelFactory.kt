package com.programmergabut.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.di.Injection
import com.programmergabut.moviecatalogue.ui.detailMovie.DetailMovieViewModel
import com.programmergabut.moviecatalogue.ui.detailTvShow.DetailTvShowViewModel
import com.programmergabut.moviecatalogue.ui.movie.MovieFragmentViewModel
import com.programmergabut.moviecatalogue.ui.tvshow.TvShowViewModel

/*
 *  Created by Katili Jiwo Adi Wiyono on 04/05/20.
 */

class ViewModelFactory(private val repository: MCRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieFragmentViewModel::class.java) -> MovieFragmentViewModel(repository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(repository) as T
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(repository) as T
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> DetailTvShowViewModel(repository) as T
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}