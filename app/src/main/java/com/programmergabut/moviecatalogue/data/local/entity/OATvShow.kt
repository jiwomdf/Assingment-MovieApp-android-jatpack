package com.programmergabut.moviecatalogue.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "msOATvShow")
data class OATvShow(
    var tvShowPosterUrl: String?,
    var title: String?,
    var score_tvShow: Float,
    var ect_tvShow: String,
    var genre_tvShow: String,
    var overview_tvShow: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}