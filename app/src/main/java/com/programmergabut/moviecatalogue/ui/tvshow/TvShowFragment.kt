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
import androidx.recyclerview.widget.RecyclerView
import com.programmergabut.moviecatalogue.R
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result
import com.programmergabut.moviecatalogue.utils.EnumStatus
import com.programmergabut.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShowFragment : Fragment() {

    lateinit var viewModel: TvShowViewModel
    private var tvShowAdapter = TvShowAdapter()
    lateinit var rv_listTvShow: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(requireActivity(), ViewModelFactory.getInstance())[TvShowViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_tv_show, container, false)

        rv_listTvShow = view.findViewById(R.id.rv_listTvShow)
        initAdapter(tvShowAdapter, rv_listTvShow)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeApi()

    }

    private fun observeApi() {
        viewModel.tvShowApi.observe(this, Observer {

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
            val new = datas.filterIndexed { index, _ -> index < 5 }
            val newSorted = new.sortedByDescending { it.voteCount }
            mvAdapter.setData(newSorted)
            mvAdapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter(
        tvShowAdapter: TvShowAdapter,
        rvListtvshow: RecyclerView
    ) {
        rvListtvshow.apply {
            this.adapter = tvShowAdapter
            this.layoutManager = LinearLayoutManager(this@TvShowFragment.context)
            setHasFixedSize(true)
        }
    }
}
