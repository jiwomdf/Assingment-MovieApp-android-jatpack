package com.programmergabut.moviecatalogue.data.remote.api
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import retrofit2.http.GET
import retrofit2.http.Query

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

interface NPMovieService {

    @GET("movie/top_rated?")
    suspend fun fetchNpMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String): NPMovieApi
}