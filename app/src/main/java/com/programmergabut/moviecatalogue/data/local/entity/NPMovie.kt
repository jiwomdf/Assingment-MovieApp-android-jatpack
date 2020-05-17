package com.programmergabut.moviecatalogue.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "msNPMovie")
data class NPMovie(
    var moviePosterUrl: String?,
    var title: String?,
    var vote: Int,
    var ect: String,
    var genre: String,
    var overview: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

