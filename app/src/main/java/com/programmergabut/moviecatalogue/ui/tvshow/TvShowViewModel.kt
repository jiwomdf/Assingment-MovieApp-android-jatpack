package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.utils.DataDummy

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowViewModel: ViewModel() {

    fun getTvShow() = DataDummy.generateTvShow()

}