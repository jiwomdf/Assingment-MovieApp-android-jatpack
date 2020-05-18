package com.programmergabut.moviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.programmergabut.moviecatalogue.ContextProviders
import com.programmergabut.moviecatalogue.data.NetworkBoundResource
import com.programmergabut.moviecatalogue.data.local.LocalDataSource
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow
import com.programmergabut.moviecatalogue.data.remote.RemoteDataSource
import com.programmergabut.moviecatalogue.data.remote.json.genre.GenreApi
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi
import com.programmergabut.moviecatalogue.utils.Resource

/*
 *  Created by Katili Jiwo Adi Wiyono on 03/05/20.
 */

class FakeMCRepository(private val remoteDataSource: RemoteDataSource,
                       private val localDataSource: LocalDataSource,
                       private val contextProviders: ContextProviders
) {


    fun getNPMovie(): LiveData<Resource<PagedList<NPMovie>>> {

        return object : NetworkBoundResource<PagedList<NPMovie>, NPMovieApi>(contextProviders) {
            public override fun loadFromDB(): LiveData<PagedList<NPMovie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<NPMovie>?): Boolean = data == null || data.isEmpty()

            public override fun createCall() = remoteDataSource.getNPMovie()

            public override fun saveCallResult(data: NPMovieApi) {
                val movieList = ArrayList<NPMovie>()
                for (itm in data.results) {
                    val movie = NPMovie(itm.posterPath, itm.title, itm.voteCount, itm.releaseDate,
                        itm.genreIds.toString(), itm.overview)
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()

    }

    fun getOATvShow(): LiveData<Resource<PagedList<OATvShow>>> {
        return object : NetworkBoundResource<PagedList<OATvShow>, OATvShowApi>(contextProviders) {
            public override fun loadFromDB(): LiveData<PagedList<OATvShow>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<OATvShow>?): Boolean = data == null || data.isEmpty()

            public override fun createCall() = remoteDataSource.getOATvShow()

            public override fun saveCallResult(data: OATvShowApi) {
                val movieList = ArrayList<OATvShow>()
                for (itm in data.results) {
                    val oaTvShow = OATvShow(itm.posterPath, itm.name, itm.voteCount, itm.firstAirDate,
                        itm.genreIds.toString(), itm.overview)
                    movieList.add(oaTvShow)
                }

                localDataSource.insertTvShow(movieList)
            }
        }.asLiveData()
    }

    fun getGenreApi(): MutableLiveData<Resource<GenreApi>> {
        val result = MutableLiveData<Resource<GenreApi>>()

        remoteDataSource.getGenre(object : RemoteDataSource.LoadGenreCallback{
            override fun onReceived(response: Resource<GenreApi>) {
                result.postValue(response)
            }
        })

        return result
    }

}