package com.programmergabut.moviecatalogue.data.remote.json

import com.google.gson.GsonBuilder
import com.programmergabut.moviecatalogue.data.remote.api.GenreService
import com.programmergabut.moviecatalogue.data.remote.api.NPMovieService
import com.programmergabut.moviecatalogue.data.remote.api.OATvShowService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {

        fun selectClass(strApi: String, selClass: Any): Any? {
            return when (selClass) {
                NPMovieService::class.java ->
                    Retrofit.Builder()
                        .baseUrl(strApi)
                        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                        .build()
                        .create(selClass as Class<*>)

                OATvShowService::class.java ->
                    Retrofit.Builder()
                        .baseUrl(strApi)
                        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                        .build()
                        .create(selClass as Class<*>)

                GenreService::class.java ->
                    Retrofit.Builder()
                        .baseUrl(strApi)
                        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                        .build()
                        .create(selClass as Class<*>)

                else -> throw Exception("no class found")

            }
        }
    }



}
