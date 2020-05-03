package com.programmergabut.moviecatalogue.data.model.local

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class Movie(

    id: Int,
    title: String,
    type: Int,
    overview: String,
    imgUrl: String,
    genere: String,
    score: Int,
    var releaseDate: String


): Show(id, title, type, overview, imgUrl, genere, score)