package com.programmergabut.moviecatalogue.data.local.room

import androidx.room.Dao
import androidx.paging.DataSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie

@Dao
interface NPMovieDao {

    @Query("SELECT * FROM msNPMovie")
    fun getNPMovie(): DataSource.Factory<Int, NPMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNPMovie(npMovie: List<NPMovie>)
}