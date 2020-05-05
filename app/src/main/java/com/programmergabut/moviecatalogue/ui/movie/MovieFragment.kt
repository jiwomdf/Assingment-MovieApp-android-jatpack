package com.programmergabut.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.model.json.npmovie.Result
import com.programmergabut.moviecatalogue.utils.EnumStatus
import com.programmergabut.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_list_movie.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieFragmentViewModel
    private val mvAdapter = MovieAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(requireActivity(), ViewModelFactory.getInstance())[MovieFragmentViewModel::class.java]

        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(mvAdapter)
        observeApi()

        viewModel.getNPMovie()
    }

    private fun observeApi() {
        viewModel.getNPMovie().observe(this, Observer {

            when(it.Status){
                EnumStatus.SUCCESS -> {
                    updateAdapterData(it.data?.results, mvAdapter)
                    pb_fragmentMovie.visibility = View.GONE
                }
                EnumStatus.LOADING -> pb_fragmentMovie.visibility = View.VISIBLE
                EnumStatus.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    pb_fragmentMovie.visibility = View.GONE
                }
            }

        })
    }

    private fun updateAdapterData(newData: List<Result>?, mvAdapter: MovieAdapter) {
        newData?.let { datas ->
            mvAdapter.setData(datas)
            mvAdapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter(mvAdapter: MovieAdapter) {
        rv_listMovie.apply {
            adapter = mvAdapter
            layoutManager = LinearLayoutManager(this@MovieFragment.context)
            setHasFixedSize(true)
        }
    }
}
