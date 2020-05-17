package com.programmergabut.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.repository.MCRepository

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragmentViewModel(repository: MCRepository): ViewModel() {

    val movie = repository.getNPMovie()

}