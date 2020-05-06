package com.programmergabut.moviecatalogue.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.google.android.material.tabs.TabLayout
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.utils.DataDummy
import com.programmergabut.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MainActivityTest{

    /*
        note:
        entah kenapa loadTvShowDetail() suka error,
        tetapi juga suka berhasil
    */

    private val dummyMovie = DataDummy.generateMovie()
    private val dummyTvShow = DataDummy.generateTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @Test
    fun loadMovie(){
        onView(withId(R.id.rv_listMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_listMovie)).perform(RecyclerViewActions
            .scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.data?.results?.size!! - 1))
    }

    @Test
    fun loadMovieDetail(){

        val dummyDataSize = dummyMovie.data?.results?.size!!
        val dummyDataList = dummyMovie.data?.results!!
        val tempGenre = "Adventure, Drama, Family"

        onView(withId(R.id.rv_listMovie)).perform(RecyclerViewActions
            .actionOnItemAtPosition<RecyclerView.ViewHolder>( dummyDataSize - 1, click()))

        onView(withId(R.id.iv_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_ect_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview_movie)).check(matches(isDisplayed()))

        //onView(withId(R.id.iv_detail)).check(matches(withText(dummyMovie[dummyMovie.size - 1].imgUrl)))
        onView(withId(R.id.tv_detail_title_movie)).check(matches(withText(dummyDataList[dummyDataSize - 1].title)))
        onView(withId(R.id.tv_detail_score_movie)).check(matches(withText("Vote Count : " + dummyDataList[dummyDataSize - 1].voteCount)))
        onView(withId(R.id.tv_detail_ect_movie)).check(matches(withText("Release Date : " + dummyDataList[dummyDataSize - 1].releaseDate)))
        onView(withId(R.id.tv_detail_genre_movie)).check(matches(withText(tempGenre)))
        onView(withId(R.id.tv_detail_overview_movie)).check(matches(withText(dummyDataList[dummyDataSize - 1].overview)))
    }

    @Test
    fun loadTvShow(){
        val dummyDataSize = dummyTvShow.data?.results?.size!!

        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rv_listTvShow)).perform(RecyclerViewActions
            .actionOnItemAtPosition<RecyclerView.ViewHolder>(dummyDataSize - 1, click()))
    }

    @Test
    fun loadTvShowDetail(){

        val dummyDataSize = dummyTvShow.data?.results?.size!!
        val dummyDataList = dummyTvShow.data?.results!!
        val tempGenre = "Drama, Mystery"

        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rv_listTvShow)).perform(RecyclerViewActions
            .actionOnItemAtPosition<RecyclerView.ViewHolder>(dummyDataSize - 1, click()))

        onView(withId(R.id.iv_detail_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_ect_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview_tvShow)).check(matches(isDisplayed()))

        //onView(withId(R.id.iv_detail)).check(matches(withText(dummyTvShow[dummyTvShow.size - 1].imgUrl)))
        onView(withId(R.id.tv_detail_title_tvShow)).check(matches(withText(dummyDataList[dummyDataSize - 1].name)))
        onView(withId(R.id.tv_detail_score_tvShow)).check(matches(withText("Vote Count : " + dummyDataList[dummyDataSize - 1].voteCount)))
        onView(withId(R.id.tv_detail_ect_tvShow)).check(matches(withText("Release Date : " + dummyDataList[dummyDataSize - 1].firstAirDate)))
        onView(withId(R.id.tv_detail_genre_tvShow)).check(matches(withText(tempGenre)))
        onView(withId(R.id.tv_detail_overview_tvShow)).check(matches(withText(dummyDataList[dummyDataSize - 1].overview)))
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() = allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }

}