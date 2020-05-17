package com.programmergabut.moviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.programmergabut.moviecatalogue.data.remote.RemoteDataSource
import com.programmergabut.moviecatalogue.data.remote.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.utils.Resource

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

class FakeMCRepository(private val remoteDataSource: RemoteDataSource) {


    fun getNPMovie(): MutableLiveData<Resource<NPMovieApi>> {
        val result = MutableLiveData<Resource<NPMovieApi>>()

        remoteDataSource.getNPMovie(object : RemoteDataSource.LoadMovieCallback{
            override fun onReceived(response: Resource<NPMovieApi>) {
                result.postValue(response)
            }
        })

        return result
    }

    fun getOATvShow(): MutableLiveData<Resource<OATvShowApi>> {
        val result = MutableLiveData<Resource<OATvShowApi>>()

        remoteDataSource.getOATvShow(object : RemoteDataSource.LoadTvShowCallback{
            override fun onReceived(response: Resource<OATvShowApi>) {
                result.postValue(response)
            }
        })
        return result
    }

    fun getGenreApi(): MutableLiveData<Resource<GenreApi>> {
        val result = MutableLiveData<Resource<GenreApi>>()

        remoteDataSource.getGenre(object : RemoteDataSource.LoadGenreCallback{
            override fun onReceived(response: Resource<GenreApi>) {
                result.postValue(response)
            }
        })

        return result
    }

}