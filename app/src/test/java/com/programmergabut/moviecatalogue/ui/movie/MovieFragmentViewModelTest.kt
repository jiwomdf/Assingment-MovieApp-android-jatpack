package com.programmergabut.moviecatalogue.ui.movie

import com.programmergabut.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragmentViewModelTest {

    private lateinit var movieFragmentViewModel: MovieFragmentViewModel

    @Before
    fun setUp(){
        movieFragmentViewModel = MovieFragmentViewModel()
    }

    @Test
    fun getMovie() {
        val data = movieFragmentViewModel.getMovie()
        assertNotNull(data)
        assertEquals(10, data.size)
    }
}