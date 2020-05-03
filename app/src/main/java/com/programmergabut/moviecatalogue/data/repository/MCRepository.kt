package com.programmergabut.moviecatalogue.data.repository

import com.google.gson.GsonBuilder
import com.programmergabut.moviecatalogue.data.api.NPMovieService
import com.programmergabut.moviecatalogue.data.api.OATvShowService
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

class MCRepository {

    //https://api.themoviedb.org/3/movie/now_playing?api_key={apiKey}&language=en-US&page=1
    //https://api.themoviedb.org/3/tv/on_the_air?api_key={apiKey}&language=en-US&page=1

    private val strApi = "https://api.themoviedb.org/3/"
    private val apiKey = ""
    private val language = "en-US"
    private val page = "1"

    private fun getNowPlayingMovieApi(): NPMovieService{
        return Builder()
            .baseUrl(strApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NPMovieService::class.java)
    }

    private fun getOnAirTvShowApi(): OATvShowService{
        return Builder()
            .baseUrl(strApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(OATvShowService::class.java)
    }

    suspend fun fetchNPMovieApi(): NPMovieApi {
        return getNowPlayingMovieApi().fetchNpMovie(apiKey, language, page)
    }

    suspend fun fetchOATvShowApi(): OATvShowApi {
        return getOnAirTvShowApi().fetchOATvShow(apiKey, language, page)
    }




}