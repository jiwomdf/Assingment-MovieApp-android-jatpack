package com.programmergabut.moviecatalogue.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.data.model.local.Movie
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.Resource
import com.programmergabut.moviecatalogue.utils.Resource.Companion.error
import com.programmergabut.moviecatalogue.utils.Resource.Companion.loading
import com.programmergabut.moviecatalogue.utils.Resource.Companion.success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragmentViewModel: ViewModel() {

    val npMovieApi = MutableLiveData<Resource<NPMovieApi>>()

    init {
        npMovieApi.postValue(loading(null))
    }

    fun getMovie(): List<Movie> = DataDummy.generateMovie()

    fun fetchNowPlayingMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                npMovieApi.postValue(success(MCRepository().fetchNPMovieApi()))
            }
            catch (ex: Exception){
                npMovieApi.postValue(error(ex.message.toString(), null))
            }
        }
    }

}