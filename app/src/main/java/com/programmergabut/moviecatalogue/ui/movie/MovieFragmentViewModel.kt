package com.programmergabut.moviecatalogue.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.Resource

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragmentViewModel(private val repository: MCRepository): ViewModel() {

    val movieApi = repository.getNPMovie()

    init {
        movieApi.postValue(Resource.loading(null))
    }

}