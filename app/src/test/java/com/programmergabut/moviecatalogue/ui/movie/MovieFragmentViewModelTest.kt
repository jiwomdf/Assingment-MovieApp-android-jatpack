package com.programmergabut.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    private lateinit var observer: Observer<Resource<NPMovieApi>>

    @Before
    fun setUp(){
        viewModel = MovieFragmentViewModel(mcrRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataDummy.generateMovie()
        val movie = MutableLiveData<Resource<NPMovieApi>>()
        movie.value = dummyMovie


        `when`(viewModel.npMovieApi).thenReturn(movie)

        val movieRetval = viewModel.npMovieApi
        CoroutineScope(Dispatchers.Default).launch {
            verify(mcrRepository).fetchNPMovieApi()
        }
        assertNotNull(movieRetval)
        assertEquals(20, movieRetval.value?.data?.results?.size)

        viewModel.npMovieApi.observeForever(observer)
        verify(observer).onChanged(dummyMovie)


    }
}