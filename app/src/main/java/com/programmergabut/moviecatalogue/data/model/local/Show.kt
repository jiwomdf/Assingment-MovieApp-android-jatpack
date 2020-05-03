package com.programmergabut.moviecatalogue.data.model.local

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

abstract class Show(
    var id: Int,
    var title: String,
    var type: Int,
    var overview: String,
    var imgUrl: String,
    var genere: String,
    var score: Int
)