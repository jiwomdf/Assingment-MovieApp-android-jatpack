package com.programmergabut.moviecatalogue.di

import android.content.Context
import com.programmergabut.moviecatalogue.data.local.LocalDataSource
import com.programmergabut.moviecatalogue.data.local.room.MovieCatalogueDatabase
import com.programmergabut.moviecatalogue.data.remote.RemoteDataSource
import com.programmergabut.moviecatalogue.data.repository.MCRepository

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */


object Injection {

    fun provideRepository(context: Context): MCRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()

        val localDataSource = LocalDataSource.getInstance(database.npMovieDao(), database.oaTvShow())


        return MCRepository.getInstance(remoteDataSource, localDataSource)
    }

}