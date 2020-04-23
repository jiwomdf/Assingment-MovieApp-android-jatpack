package com.programmergabut.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmergabut.moviecatalogue.R
import kotlinx.android.synthetic.main.fragment_list_movie.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragment : Fragment() {

    lateinit var viewModel: MovieFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[MovieFragmentViewModel::class.java]

        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_listMovie.apply {
            adapter = MovieAdapter(viewModel.getMovie())
            layoutManager = LinearLayoutManager(this@MovieFragment.context)
            setHasFixedSize(true)
        }
    }
}
