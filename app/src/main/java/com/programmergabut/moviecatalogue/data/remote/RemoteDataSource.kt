package com.programmergabut.moviecatalogue.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.programmergabut.moviecatalogue.ContextProviders
import com.programmergabut.moviecatalogue.data.remote.api.GenreService
import com.programmergabut.moviecatalogue.data.remote.api.NPMovieService
import com.programmergabut.moviecatalogue.data.remote.api.OATvShowService
import com.programmergabut.moviecatalogue.data.remote.json.RetrofitFactory
import com.programmergabut.moviecatalogue.data.remote.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.EspressoIdlingResource
import com.programmergabut.moviecatalogue.utils.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/*
 *  Created by Katili Jiwo Adi Wiyono on 05/05/20.
 */

class RemoteDataSource(private val contextProviders: ContextProviders) {

    //https://api.themoviedb.org/3/movie/now_playing?api_key={apiKey}&language=en-US&page=1
    //https://api.themoviedb.org/3/tv/on_the_air?api_key={apiKey}&language=en-US&page=1

    private val strApi = "https://api.themoviedb.org/3/"
    private val apiKey = "bcfe8d2c5ce0d14c7d32c648a1b3679d"
    private val language = "en-US"
    private val page = "1"

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(contextProviders: ContextProviders): RemoteDataSource =
            instance
                ?: synchronized(this) {
                instance
                    ?: RemoteDataSource(contextProviders)
            }
    }

    private fun getNowPlayingMovieApi(): NPMovieService =
        RetrofitFactory.selectClass(strApi, NPMovieService::class.java) as NPMovieService

    private fun getOnAirTvShowApi(): OATvShowService =
        RetrofitFactory.selectClass(strApi, OATvShowService::class.java) as OATvShowService

    private fun getGenreApi(): GenreService =
        RetrofitFactory.selectClass(strApi, GenreService::class.java) as GenreService

    private suspend fun fetchNPMovieApi(): NPMovieApi = getNowPlayingMovieApi().fetchNpMovie(apiKey, language, page)

    private suspend fun fetchOATvShowApi(): OATvShowApi = getOnAirTvShowApi().fetchOATvShow(apiKey, language, page)

    private suspend fun fetchGenreApi(): GenreApi = getGenreApi().fetchGenre(apiKey, language)


    fun getNPMovie(): LiveData<Resource<NPMovieApi>> {

        val resultContent = MutableLiveData<Resource<NPMovieApi>>()
        GlobalScope.launch(contextProviders.IO){
            EspressoIdlingResource.increment()

            try {
                resultContent.postValue(Resource.success(
                    //fetchNPMovieApi()
                    DataDummy.simulateApiMovie()
                ))
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            EspressoIdlingResource.decrement()
        }

        return resultContent
    }

    fun getOATvShow(): LiveData<Resource<OATvShowApi>> {

        val resultContent = MutableLiveData<Resource<OATvShowApi>>()
        GlobalScope.launch(contextProviders.IO){
            EspressoIdlingResource.increment()

            try {
                resultContent.postValue(Resource.success(
                    //fetchOATvShowApi()
                    DataDummy.simulateTvShowApi()
                ))
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            EspressoIdlingResource.decrement()
        }
        return resultContent
    }

    fun getGenre(callback: LoadGenreCallback){

        GlobalScope.launch(contextProviders.IO){
            EspressoIdlingResource.increment()
            try {
                callback.onReceived(Resource.success(
                    fetchGenreApi()
                ))
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadGenreCallback{
        fun onReceived(response: Resource<GenreApi>)
    }

}