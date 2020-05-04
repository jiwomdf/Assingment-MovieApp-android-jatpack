package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowViewModel(private val repository: MCRepository): ViewModel() {

    val oaTvShowApi = MutableLiveData<Resource<OATvShowApi>>()

    init {
        oaTvShowApi.postValue(Resource.loading(null))
    }

    fun getTvShow() = DataDummy.generateTvShow()

    fun fetchOnAirTvShow() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                oaTvShowApi.postValue(Resource.success(repository.fetchOATvShowApi()))
            }
            catch (ex: Exception){
                oaTvShowApi.postValue(Resource.error(ex.message.toString(), null))
            }
        }
    }
}