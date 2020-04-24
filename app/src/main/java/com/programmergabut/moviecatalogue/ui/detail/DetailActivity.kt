package com.programmergabut.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.Movie
import com.programmergabut.moviecatalogue.data.Show
import com.programmergabut.moviecatalogue.data.TvShow
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.Exception

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class DetailActivity : AppCompatActivity() {

    companion object{
        const val dataID = "data_id"
        const val dataType = "data_type"
    }

    private lateinit var viewmodel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewmodel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailActivityViewModel::class.java]

        if(intent?.extras == null)
            throw Exception("null extras")

        val dataID = intent.extras!!.getInt(dataID)
        val dataType = intent.extras!!.getInt(dataType)
        val data = viewmodel.getDetailData(dataID, dataType) as Show

        Glide.with(this)
            .load(data.imgUrl)
            .centerCrop()
            .into(iv_detail)

        when(dataType){
            1 -> tv_detail_ect.text = "Release Date : ${(data as Movie).releaseDate}"
            2 -> tv_detail_ect.text = "Network : ${(data  as TvShow).netWork}"
            else -> throw Exception("else")
        }

        tv_detail_title.text = data.title
        tv_detail_overview.text = data.overview
        tv_detail_score.text = "Score : ${data.score}"
        tv_detail_genere.text = data.genere

    }
}
