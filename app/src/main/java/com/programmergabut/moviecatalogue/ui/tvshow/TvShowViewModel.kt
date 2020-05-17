package com.programmergabut.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.programmergabut.moviecatalogue.data.repository.MCRepository

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowViewModel(repository: MCRepository): ViewModel() {

    val tvShow = repository.getOATvShow()

}