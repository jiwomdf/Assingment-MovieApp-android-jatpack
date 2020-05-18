package com.programmergabut.moviecatalogue.utils

import com.programmergabut.moviecatalogue.data.remote.json.npmovie.Dates
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.remote.json.npmovie.Result
import com.programmergabut.moviecatalogue.data.remote.json.oatvshow.OATvShowApi

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

object DataDummy{

    /*
        Untuk generateMovie & generateTvShow saya hanya mengambil
        masing - masing 5 data saja, sesuai dengan API
     */
    fun simulateApiMovie(): NPMovieApi {
        val listMovie = mutableListOf<Result>()

        listMovie.add(
            Result(
                false,
                "/wooZWiC4NWH0ahCSUOogEmVejHo.jpg",
                mutableListOf(35, 10751),
                640344,
                "it",
                "Me contro Te: Il film - La vendetta del Signor S",
                "Luì and Sofì fight the terrible Signor S once again, this time he will be revealed to the public!!!",
                17.298,
                "/4XzbcAKdX4n3aWfzBjjeAlm68S3.jpg",
                "2020-01-17",
                "Me contro Te: Il film - La vendetta del Signor S",
                false,
                8.8,
                259,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/sQkRiQo3nLrQYMXZodDjNUJKHZV.jpg",
                mutableListOf(28, 12, 16, 14, 878),
                618344,
                "en",
                "Justice League Dark: Apokolips War",
                "Earth is decimated after intergalactic tyrant Darkseid has devastated the Justice League in a poorly executed war by the DC Super Heroes. Now the remaining bastions of good – the Justice League, Teen Titans, Suicide Squad and assorted others – must regroup, strategize and take the war to Darkseid in order to save the planet and its surviving inhabitants.",
                152.046,
                "/c01Y4suApJ1Wic2xLmaq1QYcfoZ.jpg",
                "2020-05-05",
                "Justice League Dark: Apokolips War",
                false,
                8.8,
                287,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                null,
                mutableListOf(35, 18, 10749),
                19404,
                "hi",
                "दिलवाले दुल्हनिया ले जायेंगे",
                "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
                23.896,
                "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
                "1995-10-20",
                "Dilwale Dulhania Le Jayenge",
                false,
                8.8,
                2277,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/avedvodAZUcwqevBfm8p4G2NziQ.jpg",
                mutableListOf(80, 18),
                278,
                "en",
                "The Shawshank Redemption",
                "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                45.386,
                "/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg",
                "1994-09-23",
                "The Shawshank Redemption",
                false,
                8.7,
                16098,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/re3ZvlKJg04iLpLRf1xTKHS2wLU.jpg",
                mutableListOf(12, 16, 35, 14, 10402, 878, 10751, 10770),
                537061,
                "en",
                "Steven Universe: The Movie",
                "Two years after the events of \"Change Your Mind\", Steven (now 16 years old) and his friends are ready to enjoy the rest of their lives peacefully. However, all of that changes when a new sinister Gem arrives, armed with a giant drill that saps the life force of all living things on Earth. In their biggest challenge ever, the Crystal Gems must work together to save all organic life on Earth within 48 hours.",
                14.459,
                "/8mRgpubxHqnqvENK4Bei30xMDvy.jpg",
                "2019-09-02",
                "Steven Universe: The Movie",
                false,
                8.7,
                270,
                EnumConfig.typeMovie
            )
        )

        return NPMovieApi(Dates("2020-05-18","2020-05-18"), 1, listMovie, 365, 7292)
    }

    fun simulateTvShowApi(): OATvShowApi {
        val listTvShow = mutableListOf<com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result>()

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            null, "2004-05-10", mutableListOf(16, 35), 100,
            "I Am Not an Animal", mutableListOf("GB"), "en", "I Am Not an Animal",
            "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
            12.13, "/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg", 9.4, 449, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/uAjMQlbPkVHmUahhCouANlHSDW2.jpg",
            "2019-01-09",
            mutableListOf(16, 18, 9648, 10759, 10765),
            60625,
            "The Promised Neverland",
            mutableListOf("JP"),
            "ja",
            "約束のネバーランド",
            "The one adored as the mother is not the real parent.  The people living here together are not actual siblings. The Gracefield House is where orphaned children live. An irreplaceable home where 38 siblings and Mom live happy lives, even with no blood relations.  However, their everyday life suddenly came to an abrupt end one day...",
            11.391,
            "/1sKCm6vJbDq64zcfHNOY67ltLns.jpg",
            9.1,
            107,
            EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/AvHqemLogpyR2Bg4yTlT1DPzrH.jpg", "1993-10-16", mutableListOf(16, 35),
            42573, "Slam Dunk", mutableListOf("JP"), "ja", "スラムダンク",
            "Sakuragi Hanamichi is a junior high punk used to getting into fights and being rejected by girls but upon entering high school he meets the girl of his dreams, Haruko Akagi. He will do anything in order to win her heart including joining the school basketball team that is aiming to conquer the nation lead by Haruko's brother. The problem is that Sakuragi has never played basketball before and a freshman sensation is stealing the spotlight and Haruko's affection from him."
            , 14.842, "/65Xo6gKpREqXpzliLx9PYqSQ4O.jpg", 8.9, 117, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/qSgBzXdu6QwVVeqOYOlHolkLRxZ.jpg",
            "2019-01-09",
            mutableListOf(16, 10759, 10765, 18),
            83095,
            "The Rising of the Shield Hero",
            mutableListOf("US"),
            "ja",
            "盾の勇者の成り上がり",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins..."
            ,
            9.055,
            "/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
            8.8,
            117,
            EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/nTvM4mhqNlHIvUkI1gVnW6XP7GG.jpg", "2019-04-06", mutableListOf(16, 18, 10759, 10765),
            85937, "Demon Slayer: Kimetsu no Yaiba", mutableListOf("JP"), "ja", "鬼滅の刃",
            "It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself. Though devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.",
            4.317, "/wrCVHdkBlBWdJUZPvnJWcBRuhSY.jpg", 8.8, 397, EnumConfig.typeTvShow
        )))


        return OATvShowApi(1,listTvShow, 46, 902)
    }

    //DUMMY DATA (Data sama hanya beda return type)

    fun generateMovie(): List<Result> {
        val listMovie = mutableListOf<Result>()

        listMovie.add(
            Result(
                false,
                "/wooZWiC4NWH0ahCSUOogEmVejHo.jpg",
                mutableListOf(35, 10751),
                640344,
                "it",
                "Me contro Te: Il film - La vendetta del Signor S",
                "Luì and Sofì fight the terrible Signor S once again, this time he will be revealed to the public!!!",
                17.298,
                "/4XzbcAKdX4n3aWfzBjjeAlm68S3.jpg",
                "2020-01-17",
                "Me contro Te: Il film - La vendetta del Signor S",
                false,
                8.8,
                259,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/sQkRiQo3nLrQYMXZodDjNUJKHZV.jpg",
                mutableListOf(28, 12, 16, 14, 878),
                618344,
                "en",
                "Justice League Dark: Apokolips War",
                "Earth is decimated after intergalactic tyrant Darkseid has devastated the Justice League in a poorly executed war by the DC Super Heroes. Now the remaining bastions of good – the Justice League, Teen Titans, Suicide Squad and assorted others – must regroup, strategize and take the war to Darkseid in order to save the planet and its surviving inhabitants.",
                152.046,
                "/c01Y4suApJ1Wic2xLmaq1QYcfoZ.jpg",
                "2020-05-05",
                "Justice League Dark: Apokolips War",
                false,
                8.8,
                287,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                null,
                mutableListOf(35, 18, 10749),
                19404,
                "hi",
                "दिलवाले दुल्हनिया ले जायेंगे",
                "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
                23.896,
                "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
                "1995-10-20",
                "Dilwale Dulhania Le Jayenge",
                false,
                8.8,
                2277,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/avedvodAZUcwqevBfm8p4G2NziQ.jpg",
                mutableListOf(80, 18),
                278,
                "en",
                "The Shawshank Redemption",
                "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                45.386,
                "/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg",
                "1994-09-23",
                "The Shawshank Redemption",
                false,
                8.7,
                16098,
                EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,
                "/re3ZvlKJg04iLpLRf1xTKHS2wLU.jpg",
                mutableListOf(12, 16, 35, 14, 10402, 878, 10751, 10770),
                537061,
                "en",
                "Steven Universe: The Movie",
                "Two years after the events of \"Change Your Mind\", Steven (now 16 years old) and his friends are ready to enjoy the rest of their lives peacefully. However, all of that changes when a new sinister Gem arrives, armed with a giant drill that saps the life force of all living things on Earth. In their biggest challenge ever, the Crystal Gems must work together to save all organic life on Earth within 48 hours.",
                14.459,
                "/8mRgpubxHqnqvENK4Bei30xMDvy.jpg",
                "2019-09-02",
                "Steven Universe: The Movie",
                false,
                8.7,
                270,
                EnumConfig.typeMovie
            )
        )

        return listMovie
    }

    fun generateTvShow(): List<com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result> {
        val listTvShow = mutableListOf<com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result>()

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            null, "2004-05-10", mutableListOf(16, 35), 100,
            "I Am Not an Animal", mutableListOf("GB"), "en", "I Am Not an Animal",
            "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
            12.13, "/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg", 9.4, 449, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/uAjMQlbPkVHmUahhCouANlHSDW2.jpg",
            "2019-01-09",
            mutableListOf(16, 18, 9648, 10759, 10765),
            60625,
            "The Promised Neverland",
            mutableListOf("JP"),
            "ja",
            "約束のネバーランド",
            "The one adored as the mother is not the real parent.  The people living here together are not actual siblings. The Gracefield House is where orphaned children live. An irreplaceable home where 38 siblings and Mom live happy lives, even with no blood relations.  However, their everyday life suddenly came to an abrupt end one day...",
            11.391,
            "/1sKCm6vJbDq64zcfHNOY67ltLns.jpg",
            9.1,
            107,
            EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/AvHqemLogpyR2Bg4yTlT1DPzrH.jpg", "1993-10-16", mutableListOf(16, 35),
            42573, "Slam Dunk", mutableListOf("JP"), "ja", "スラムダンク",
            "Sakuragi Hanamichi is a junior high punk used to getting into fights and being rejected by girls but upon entering high school he meets the girl of his dreams, Haruko Akagi. He will do anything in order to win her heart including joining the school basketball team that is aiming to conquer the nation lead by Haruko's brother. The problem is that Sakuragi has never played basketball before and a freshman sensation is stealing the spotlight and Haruko's affection from him."
            , 14.842, "/65Xo6gKpREqXpzliLx9PYqSQ4O.jpg", 8.9, 117, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/qSgBzXdu6QwVVeqOYOlHolkLRxZ.jpg",
            "2019-01-09",
            mutableListOf(16, 10759, 10765, 18),
            83095,
            "The Rising of the Shield Hero",
            mutableListOf("US"),
            "ja",
            "盾の勇者の成り上がり",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins..."
            ,
            9.055,
            "/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
            8.8,
            117,
            EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.remote.json.oatvshow.Result(
            "/nTvM4mhqNlHIvUkI1gVnW6XP7GG.jpg", "2019-04-06", mutableListOf(16, 18, 10759, 10765),
            85937, "Demon Slayer: Kimetsu no Yaiba", mutableListOf("JP"), "ja", "鬼滅の刃",
            "It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself. Though devastated by this grim reality, Tanjiro resolves to become a “demon slayer” so that he can turn his sister back into a human, and kill the demon that massacred his family.",
            4.317, "/wrCVHdkBlBWdJUZPvnJWcBRuhSY.jpg", 8.8, 397, EnumConfig.typeTvShow
        )))


        return listTvShow
    }
}