package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/*
 *  Created by Katili Jiwo Adi Wiyono on 24/04/20.
 */

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mcrRepository: MCRepository

    @Mock
    private lateinit var observer: Observer<Resource<OATvShowApi>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(mcrRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.generateTvShow()
        val tvShow = MutableLiveData<Resource<OATvShowApi>>()
        tvShow.value = dummyTvShow

        `when`(mcrRepository.getOATvShow()).thenReturn(tvShow)

        val tvShowRetVal = viewModel.oaTvShow()
        verify(mcrRepository).getOATvShow()
        assertNotNull(tvShowRetVal)
        assertEquals(5, tvShowRetVal.value?.data?.results?.size)

        viewModel.oaTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}