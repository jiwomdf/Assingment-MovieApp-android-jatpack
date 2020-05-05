package com.programmergabut.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.repository.MCRepository

class DetailTvShowViewModel(private val repository: MCRepository): ViewModel() {

    fun genre()  = repository.getGenreApi()

}