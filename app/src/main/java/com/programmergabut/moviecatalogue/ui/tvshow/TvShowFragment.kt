package com.programmergabut.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmergabut.moviecatalogue.R
import kotlinx.android.synthetic.main.fragment_tv_show.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowFragment : Fragment() {

    lateinit var viewModel: TvShowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_listTvShow.apply {
            adapter = TvShowAdapter(viewModel.getTvShow())
            layoutManager = LinearLayoutManager(this@TvShowFragment.context)
            setHasFixedSize(true)
        }
    }
}
