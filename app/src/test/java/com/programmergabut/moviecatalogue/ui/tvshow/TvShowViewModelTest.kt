package com.programmergabut.moviecatalogue.ui.tvshow

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 24/04/20.
 */

class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val data = tvShowViewModel.getTvShow()
        assertNotNull(data)
        assertEquals(data.size, 10)
    }
}