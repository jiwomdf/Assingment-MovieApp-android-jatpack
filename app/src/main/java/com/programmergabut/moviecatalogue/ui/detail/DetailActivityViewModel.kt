package com.programmergabut.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.utils.DataDummy

class DetailActivityViewModel: ViewModel() {

    fun getDetailData(id: Int, type: Int): Any? {

        return if(type == 1)
            DataDummy.generateMovie().find { it.id == id }
        else
            DataDummy.generateTvShow().find { it.id == id }
    }
}