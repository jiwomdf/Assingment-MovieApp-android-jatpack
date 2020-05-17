package com.programmergabut.moviecatalogue.data.remote.api

import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import retrofit2.http.GET
import retrofit2.http.Query

interface OATvShowService {

    @GET("tv/top_rated?")
    suspend fun fetchOATvShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String): OATvShowApi
}