package com.programmergabut.moviecatalogue.data.api
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import retrofit2.http.GET
import retrofit2.http.Query

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

interface NPMovieService {

    @GET("movie/now_playing?")
    suspend fun fetchNpMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String): NPMovieApi
}