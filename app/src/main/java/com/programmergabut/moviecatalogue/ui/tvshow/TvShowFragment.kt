package com.programmergabut.moviecatalogue.ui.tvshow

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
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result
import com.programmergabut.moviecatalogue.ui.movie.MovieAdapter
import com.programmergabut.moviecatalogue.utils.EnumStatus
import kotlinx.android.synthetic.main.fragment_list_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowFragment : Fragment() {

    lateinit var viewModel: TvShowViewModel
    private val tvShowAdapter = TvShowAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(tvShowAdapter)
        observeApi()

        viewModel.fetchOnAirTvShow()
    }

    private fun observeApi() {
        viewModel.oaTvShowApi.observe(this, Observer {

            when(it.Status){
                EnumStatus.SUCCESS -> {
                    updateAdapterData(it.data?.results, tvShowAdapter)
                    pb_fragmentTvShow.visibility = View.GONE
                }
                EnumStatus.LOADING -> pb_fragmentTvShow.visibility = View.VISIBLE
                EnumStatus.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    pb_fragmentTvShow.visibility = View.GONE
                }
            }

        })
    }

    private fun updateAdapterData(newData: List<Result>?, mvAdapter: TvShowAdapter) {
        newData?.let { datas ->
            mvAdapter.setData(datas)
            mvAdapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter(tvShowAdapter: TvShowAdapter) {
        rv_listTvShow.apply {
            this.adapter = tvShowAdapter
            this.layoutManager = LinearLayoutManager(this@TvShowFragment.context)
            setHasFixedSize(true)
        }
    }
}
