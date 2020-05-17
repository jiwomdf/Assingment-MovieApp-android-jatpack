package com.programmergabut.moviecatalogue.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.programmergabut.moviecatalogue.data.remote.RemoteDataSource
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.LiveDataTestUtil
import com.programmergabut.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.mock

/*
 *  Created by Katili Jiwo Adi Wiyono on 06/05/20.
 */

class MCRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val mcrRepository = FakeMCRepository(remote)
    //movie
    private val movieResponse = Resource.success(DataDummy.generateMovie().data!!)
    private val firstMovieID = movieResponse.data?.results!![0]

    //tvShow
    private val tvShowResponse = Resource.success(DataDummy.generateTvShow().data!!)
    private val firstTvShowID = tvShowResponse.data?.results!![0]

    @Test
    fun getAllMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieCallback).onReceived(movieResponse)
            null
        }.`when`(remote).getNPMovie(any())

        val movieApi = LiveDataTestUtil.getValue(mcrRepository.getNPMovie())

        verify(remote).getNPMovie(any())
        assertNotNull(movieApi)
        assertEquals(movieResponse.data?.results?.size?.toLong(), movieApi.data?.results?.size?.toLong())

        assertEquals(firstMovieID, movieApi.data?.results!![0])
    }

    @Test
    fun getAllTvShow(){
        doAnswer{
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback).onReceived(tvShowResponse)
            null
        }.`when`(remote).getOATvShow(any())

        val tvShowApi = LiveDataTestUtil.getValue(mcrRepository.getOATvShow())

        verify(remote).getOATvShow(any())
        assertNotNull(tvShowApi)
        assertEquals(tvShowResponse.data?.results?.size?.toLong(), tvShowApi.data?.results?.size?.toLong())

        assertEquals(firstTvShowID, tvShowApi.data?.results!![0])
    }

}