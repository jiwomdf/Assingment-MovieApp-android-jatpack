package com.programmergabut.moviecatalogue.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.programmergabut.moviecatalogue.data.local.entity.NPMovie

@Database(entities = [NPMovie::class], version = 1, exportSchema = false)
abstract class MovieCatalogueDatabase: RoomDatabase() {

    abstract fun npMovieDao(): NPMovieDao
    abstract fun oaTvShow(): OATvShowDao

    companion object {
        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "MovieCatalogue.db").build()
            }
    }


}