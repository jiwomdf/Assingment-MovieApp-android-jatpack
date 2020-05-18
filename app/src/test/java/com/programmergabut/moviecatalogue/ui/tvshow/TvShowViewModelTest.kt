package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow
import com.programmergabut.moviecatalogue.data.repository.MCRepository
import com.programmergabut.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
    private lateinit var observer: Observer<Resource<PagedList<OATvShow>>>

    @Mock
    private lateinit var pagedList: PagedList<OATvShow>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(mcrRepository)
    }

    @Test
    fun getTvShow() {

        val dummyCourses = Resource.success(pagedList)
        `when`(dummyCourses.data?.size).thenReturn(5)
        val tvShow = MutableLiveData<Resource<PagedList<OATvShow>>>()
        tvShow.value = dummyCourses

        `when`(mcrRepository.getOATvShow()).thenReturn(tvShow)

        val courseEntities = viewModel.tvShow()
        Mockito.verify(mcrRepository).getOATvShow()

        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.value?.data?.size)

        viewModel.tvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourses)


        /* val dummyTvShow = DataDummy.generateTvShow()
        val tvShow = MutableLiveData<Resource<OATvShowApi>>()
        tvShow.value = dummyTvShow

        `when`(mcrRepository.getOATvShow()).thenReturn(tvShow)

        val tvShowRetVal = viewModel.oaTvShow()
        verify(mcrRepository).getOATvShow()
        assertNotNull(tvShowRetVal)
        assertEquals(5, tvShowRetVal.value.data.results.size)

        viewModel.oaTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow) */
    }
}