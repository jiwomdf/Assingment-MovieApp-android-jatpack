package com.programmergabut.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie
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

        viewModel = ViewModelProvider(requireActivity(), ViewModelFactory.getInstance(this.context!!))[MovieFragmentViewModel::class.java]

        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(mvAdapter)
        observeApi()
    }

    private fun observeApi() {
        viewModel.movie().observe(this, Observer {

            when(it.Status){
                EnumStatus.SUCCESS -> {
                    updateAdapterData(it.data, mvAdapter)
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

    private fun updateAdapterData(newData: PagedList<NPMovie>?, mvAdapter: MovieAdapter) {
        newData?.let { datas ->
            mvAdapter.submitList(datas)
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
