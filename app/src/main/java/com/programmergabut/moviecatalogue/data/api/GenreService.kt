package com.programmergabut.moviecatalogue.data.api

import com.programmergabut.moviecatalogue.data.model.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("genre/movie/list?")
    suspend fun fetchGenre(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): GenreApi
}