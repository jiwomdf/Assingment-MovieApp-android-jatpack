package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.Resource

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowViewModel(private val repository: MCRepository): ViewModel() {

    val tvShowApi = repository.getOATvShow()

    init {
        tvShowApi.postValue(Resource.loading(null))
    }
}