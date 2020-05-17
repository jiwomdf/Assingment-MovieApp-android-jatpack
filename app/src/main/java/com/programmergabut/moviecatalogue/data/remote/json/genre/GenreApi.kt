package com.programmergabut.moviecatalogue.data.remote.json.genre


import com.google.gson.annotations.SerializedName

data class GenreApi(
    @SerializedName("genres")
    val genres: List<Genre>
)