package com.programmergabut.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/*
 *  Created by Katili Jiwo Adi Wiyono on 24/04/20.
 */

@RunWith(MockitoJUnitRunner::class)
class MovieFragmentViewModelTest {

    private lateinit var viewModel: MovieFragmentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mcrRepository: MCRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<NPMovie>>>

    @Mock
    private lateinit var pagedList: PagedList<NPMovie>

    @Before
    fun setUp(){
        viewModel = MovieFragmentViewModel(mcrRepository)
    }

    @Test
    fun getMovie() {

        val dummyCourses = Resource.success(pagedList)
        `when`(dummyCourses.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resource<PagedList<NPMovie>>>()
        movie.value = dummyCourses


        `when`(mcrRepository.getNPMovie()).thenReturn(movie)

        val movieRetVal = viewModel.movie()
        verify(mcrRepository).getNPMovie()

        assertNotNull(movieRetVal)
        assertEquals(5, movieRetVal.value?.data?.size)

        viewModel.movie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)


        /* val dummyMovie = DataDummy.generateMovie()
        val movie = MutableLiveData<Resource<NPMovieApi>>()
        movie.value = dummyMovie

        `when`(mcrRepository.getNPMovie()).thenReturn(movie)

        val movieRetval = viewModel.nPMovie()
        verify(mcrRepository).getNPMovie()
        assertNotNull(movieRetval)
        assertEquals(5, movieRetval.value.data.results.size)

        viewModel.nPMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie) */
    }
}