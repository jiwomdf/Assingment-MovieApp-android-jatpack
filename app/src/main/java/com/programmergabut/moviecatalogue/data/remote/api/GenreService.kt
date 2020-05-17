package com.programmergabut.moviecatalogue.data.remote.api

import com.programmergabut.moviecatalogue.data.remote.json.genre.GenreApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("genre/movie/list?")
    suspend fun fetchGenre(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): GenreApi
}