package com.programmergabut.moviecatalogue.ui.detailMovie

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.repository.MCRepository

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/05/20.
 */

class DetailMovieViewModel(private val repository: MCRepository): ViewModel() {

    fun genre() = repository.getGenreApi()

}