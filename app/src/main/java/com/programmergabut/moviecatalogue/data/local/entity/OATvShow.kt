package com.programmergabut.moviecatalogue.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "msOATvShow")
data class OATvShow(
    var tvShowPosterUrl: String?,
    var title: String?,
    var vote: Int,
    var ect: String,
    var genre: String,
    var overview: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}