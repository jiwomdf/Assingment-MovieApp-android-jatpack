package com.programmergabut.moviecatalogue.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.programmergabut.moviecatalogue.data.remote.api.GenreService
import com.programmergabut.moviecatalogue.data.remote.api.NPMovieService
import com.programmergabut.moviecatalogue.data.remote.api.OATvShowService
import com.programmergabut.moviecatalogue.data.remote.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 *  Created by Katili Jiwo Adi Wiyono on 05/05/20.
 */

class RemoteDataSource {

    //https://api.themoviedb.org/3/movie/now_playing?api_key={apiKey}&language=en-US&page=1
    //https://api.themoviedb.org/3/tv/on_the_air?api_key={apiKey}&language=en-US&page=1

    private val strApi = "https://api.themoviedb.org/3/"
    private val apiKey = "bcfe8d2c5ce0d14c7d32c648a1b3679d"
    private val language = "en-US"
    private val page = "1"

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance
                ?: synchronized(this) {
                instance
                    ?: RemoteDataSource()
            }
    }

    private fun getNowPlayingMovieApi(): NPMovieService {
        return Retrofit.Builder()
            .baseUrl(strApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NPMovieService::class.java)
    }

    private fun getOnAirTvShowApi(): OATvShowService {
        return Retrofit.Builder()
            .baseUrl(strApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(OATvShowService::class.java)
    }

    private fun getGenreApi(): GenreService {
        return Retrofit.Builder()
            .baseUrl(strApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GenreService::class.java)
    }

    private suspend fun fetchNPMovieApi(): NPMovieApi = getNowPlayingMovieApi().fetchNpMovie(apiKey, language, page)

    private suspend fun fetchOATvShowApi(): OATvShowApi = getOnAirTvShowApi().fetchOATvShow(apiKey, language, page)

    private suspend fun fetchGenreApi(): GenreApi = getGenreApi().fetchGenre(apiKey, language)


    fun getNPMovie(): LiveData<Resource<NPMovieApi>> {

        val resultContent = MutableLiveData<Resource<NPMovieApi>>()
        CoroutineScope(Dispatchers.Default).launch{
            //EspressoIdlingResource.increment()

            try {
                resultContent.value = Resource.success(fetchNPMovieApi())
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            //EspressoIdlingResource.decrement()
        }

        return resultContent
    }

    fun getOATvShow(): LiveData<Resource<OATvShowApi>> {

        val resultContent = MutableLiveData<Resource<OATvShowApi>>()
        CoroutineScope(Dispatchers.Default).launch{
            //EspressoIdlingResource.increment()

            try {
                resultContent.value = Resource.success(fetchOATvShowApi())
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            //EspressoIdlingResource.decrement()
        }
        return resultContent
    }

    fun getGenre(callback: LoadGenreCallback){

        CoroutineScope(Dispatchers.Default).launch{
            //EspressoIdlingResource.increment()
            try {
                callback.onReceived(Resource.success(fetchGenreApi()))
            }
            catch (ex: Exception){
                Resource.error(ex.message.toString(), null)
            }
            //EspressoIdlingResource.decrement()
        }
    }

    interface LoadGenreCallback{
        fun onReceived(response: Resource<GenreApi>)
    }

}