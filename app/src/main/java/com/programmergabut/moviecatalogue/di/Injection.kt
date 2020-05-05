package com.programmergabut.moviecatalogue.di

import com.programmergabut.moviecatalogue.data.RemoteDataSource
import com.programmergabut.moviecatalogue.data.repository.MCRepository

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */


object Injection {

    fun provideRepository(): MCRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MCRepository.getInstance(remoteDataSource)
    }

}