package com.programmergabut.moviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.programmergabut.moviecatalogue.data.RemoteDataSource
import com.programmergabut.moviecatalogue.data.model.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.utils.EspressoIdlingResource
import com.programmergabut.moviecatalogue.utils.Resource
import com.programmergabut.moviecatalogue.utils.Resource.Companion.error
import com.programmergabut.moviecatalogue.utils.Resource.Companion.success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

class MCRepository(private val remoteDataSource: RemoteDataSource) {


    companion object {
        @Volatile
        private var instance: MCRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MCRepository =
            instance ?: synchronized(this) {
                instance ?: MCRepository(remoteDataSource)
            }
    }


    fun getNPMovie(): MutableLiveData<Resource<NPMovieApi>> {
        val result = MutableLiveData<Resource<NPMovieApi>>()

        CoroutineScope(Dispatchers.Default).launch{
            EspressoIdlingResource.increment()
            try {
                result.postValue(success(remoteDataSource.fetchNPMovieApi()))
            }
            catch (ex: Exception){
                result.postValue(error(ex.message.toString(), null))
            }
            EspressoIdlingResource.decrement()
        }

        return result
    }

    fun getOATvShow(): MutableLiveData<Resource<OATvShowApi>> {
        val result = MutableLiveData<Resource<OATvShowApi>>()

        CoroutineScope(Dispatchers.Default).launch{
            EspressoIdlingResource.increment()
            try {
                result.postValue(success(remoteDataSource.fetchOATvShowApi()))
            }
            catch (ex: Exception){
                result.postValue(error(ex.message.toString(), null))
            }
            EspressoIdlingResource.decrement()
        }

        return result
    }

    fun getGenreApi(): MutableLiveData<Resource<GenreApi>> {
        val result = MutableLiveData<Resource<GenreApi>>()

        CoroutineScope(Dispatchers.Default).launch{
            EspressoIdlingResource.increment()
            try {
                result.postValue(success(remoteDataSource.fetchGenreApi()))
            }
            catch (ex: Exception){
                result.postValue(error(ex.message.toString(), null))
            }
            EspressoIdlingResource.decrement()
        }

        return result
    }

}