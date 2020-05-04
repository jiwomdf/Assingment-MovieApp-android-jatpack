package com.programmergabut.moviecatalogue.ui.detailMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmergabut.moviecatalogue.data.model.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val repository: MCRepository): ViewModel() {

    val genreApi = MutableLiveData<Resource<GenreApi>>()

    init {
        genreApi.postValue(Resource.loading(null))
    }

    fun fetchGenreApi() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                genreApi.postValue(Resource.success(repository.fetchGenreApi()))
            }
            catch (ex: Exception){
                genreApi.postValue(Resource.error(ex.message.toString(), null))
            }
        }
    }

}