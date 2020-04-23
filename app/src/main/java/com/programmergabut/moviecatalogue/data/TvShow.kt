package com.programmergabut.moviecatalogue.data

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

class TvShow(

    id: Int,
    title: String,
    type: Int,
    overview: String,
    imgUrl: String,
    genere: String,
    score: Int,
    var netWork: String

): Show(id, title, type, overview, imgUrl, genere, score)