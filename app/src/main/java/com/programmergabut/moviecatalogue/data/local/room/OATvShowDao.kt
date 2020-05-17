package com.programmergabut.moviecatalogue.data.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.programmergabut.moviecatalogue.data.local.entity.OATvShow

@Dao
interface OATvShowDao {

    @Query("SELECT * FROM msOATvShow")
    fun getOATvShow(): DataSource.Factory<Int, OATvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(npMovie: List<OATvShow>)

}