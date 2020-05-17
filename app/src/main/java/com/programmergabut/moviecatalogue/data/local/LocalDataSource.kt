package com.programmergabut.moviecatalogue.data.local

import androidx.paging.DataSource
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow
import com.programmergabut.moviecatalogue.data.local.room.NPMovieDao
import com.programmergabut.moviecatalogue.data.local.room.OATvShowDao

class LocalDataSource private constructor(private val npMovieDao: NPMovieDao, private val oaTvShowDao: OATvShowDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: NPMovieDao, oaTvShowDao: OATvShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(academyDao, oaTvShowDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, NPMovie> = npMovieDao.getNPMovie()

    fun getAllTvShow(): DataSource.Factory<Int, OATvShow> = oaTvShowDao.getOATvShow()

    fun insertMovie(npMovies: List<NPMovie>) = npMovieDao.insertNPMovie(npMovies)

    fun insertTvShow(oatvShows: List<OATvShow>) = oaTvShowDao.insertTvShow(oatvShows)

}