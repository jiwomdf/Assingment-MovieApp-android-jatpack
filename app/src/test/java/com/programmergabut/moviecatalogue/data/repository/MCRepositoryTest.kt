package com.programmergabut.moviecatalogue.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.programmergabut.moviecatalogue.ContextProviders
import com.programmergabut.moviecatalogue.data.local.LocalDataSource
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow
import com.programmergabut.moviecatalogue.data.remote.RemoteDataSource
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.PagedListUtil
import com.programmergabut.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 06/05/20.
 */

class MCRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val contextProviders = mock(ContextProviders::class.java)

    private val mcrRepository = FakeMCRepository(remote, local, contextProviders)

    //movie
    private val movieResponse = DataDummy.generateMovie()
    //private val firstMovieID = movieResponse.data?.results!![0]

    //tvShow
    private val tvShowResponse = DataDummy.generateTvShow()
    //private val firstTvShowID = tvShowResponse.data?.results!![0]

    @Test
    fun getAllMovie() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NPMovie>

        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        mcrRepository.getNPMovie()

        val movieRetVal = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieRetVal.data)
        assertEquals(movieResponse.size.toLong(), movieRetVal.data?.size?.toLong())

        //assertEquals(firstMovieID, movieApi.data?.results!![0])
    }

    @Test
    fun getAllTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, OATvShow>

        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        mcrRepository.getOATvShow()

        val tvShowRetVal = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowRetVal.data)
        assertEquals(movieResponse.size.toLong(), tvShowRetVal.data?.size?.toLong())

        //assertEquals(firstTvShowID, tvShowApi.data?.results!![0])
    }

}