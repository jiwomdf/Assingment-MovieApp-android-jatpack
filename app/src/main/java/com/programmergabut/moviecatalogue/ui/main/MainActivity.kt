package com.programmergabut.moviecatalogue.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.programmergabut.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_main.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = SectionPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }



}
