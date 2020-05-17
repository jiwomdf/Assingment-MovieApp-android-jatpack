package com.programmergabut.moviecatalogue.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "msNPMovie")
data class NPMovie(
    var moviePosterUrl: String?,
    var title: String?,
    var score_movie: Float,
    var ect_movie: String,
    var genre_movie: String,
    var overview_movie: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

