package com.programmergabut.moviecatalogue.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
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
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MainActivityTest{

    /*  Scenario

        1. load movie
        a. check if rv_listMovie displayed
        b. scroll to the end of the recyclerview data

        2. load movie detail
        a. click the last rv_listMovie data
        b. check if iv_detail, tv_detail_title, tv_detail_score, tv_detail_ect, tv_detail_genere, tv_detail_overview displayed
        c. check if iv_detail, tv_detail_title, tv_detail_score, tv_detail_ect, tv_detail_genere, tv_detail_overview value equal to the dummy data

        3. load tvShow
        a. check if rv_listTvShow displayed
        b. scroll to sthe end of the recyclerview data

        4. load tvShow detail
        a. click the last rv_listTvShow data
        b. check if iv_detail, tv_detail_title, tv_detail_score, tv_detail_ect, tv_detail_genere, tv_detail_overview displayed
        c. check if iv_detail, tv_detail_title, tv_detail_score, tv_detail_ect, tv_detail_genere, tv_detail_overview value equal to the dummy data
     */


    private val dummyMovie = DataDummy.generateMovie()
    private val dummyTvShow = DataDummy.generateTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie(){
        onView(withId(R.id.rv_listMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_listMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size - 1))
    }

    @Test
    fun loadMovieDetail(){
        onView(withId(R.id.rv_listMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(dummyMovie.size - 1, click()))

        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_ect)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genere)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))

        //onView(withId(R.id.iv_detail)).check(matches(withText(dummyMovie[dummyMovie.size - 1].imgUrl)))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovie[dummyMovie.size - 1].title)))
        onView(withId(R.id.tv_detail_score)).check(matches(withText("Score : " + dummyMovie[dummyMovie.size - 1].score)))
        onView(withId(R.id.tv_detail_ect)).check(matches(withText("Release Date : " + dummyMovie[dummyMovie.size - 1].releaseDate)))
        onView(withId(R.id.tv_detail_genere)).check(matches(withText(dummyMovie[dummyMovie.size - 1].genere)))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyMovie[dummyMovie.size - 1].overview)))
    }

    @Test
    fun loadTvShow(){
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rv_listTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(dummyTvShow.size - 1, click()))
    }

    @Test
    fun loadTvShowDetail(){
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rv_listTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(dummyTvShow.size - 1, click()))

        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_ect)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genere)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))

        //onView(withId(R.id.iv_detail)).check(matches(withText(dummyTvShow[dummyTvShow.size - 1].imgUrl)))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTvShow[dummyTvShow.size - 1].title)))
        onView(withId(R.id.tv_detail_score)).check(matches(withText("Score : " + dummyTvShow[dummyTvShow.size - 1].score)))
        onView(withId(R.id.tv_detail_ect)).check(matches(withText("Network : " + dummyTvShow[dummyTvShow.size - 1].netWork)))
        onView(withId(R.id.tv_detail_genere)).check(matches(withText(dummyTvShow[dummyTvShow.size - 1].genere)))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyTvShow[dummyTvShow.size - 1].overview)))
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