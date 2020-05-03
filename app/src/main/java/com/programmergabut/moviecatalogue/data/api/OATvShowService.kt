package com.programmergabut.moviecatalogue.data.api

import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi
import retrofit2.http.GET
import retrofit2.http.Query

interface OATvShowService {

    @GET("tv/on_the_air?")
    suspend fun fetchOATvShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String): OATvShowApi
}