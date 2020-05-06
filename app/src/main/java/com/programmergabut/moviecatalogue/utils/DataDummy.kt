package com.programmergabut.moviecatalogue.utils

import com.programmergabut.moviecatalogue.data.model.json.npmovie.Dates
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.model.json.npmovie.Result
import com.programmergabut.moviecatalogue.data.model.json.oatvshow.OATvShowApi

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

object DataDummy{

    /*
        Untuk generateMovie & generateTvShow saya hanya mengambil
        masing - masing 5 data saja, sesuai dengan API
     */

    fun generateMovie(): Resource<NPMovieApi> {
        val listMovie = mutableListOf<Result>()

        listMovie.add(
            Result(
                false,"/mUhh8glXvRfRIpX6jiUctEvg4IB.jpg", mutableListOf(28, 35, 878, 10751),454626,"en",
                "Sonic the Hedgehog", "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                212.138,"/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg", "2020-02-12", "Sonic the Hedgehog", false,
                7.5, 3511, EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,"/ocUrMYbdjknu2TwzMHKT9PBBQRw.jpg", mutableListOf(28,878),338762,"en",
                "Bloodshot", "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
                189.831,"/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg", "2020-03-05", "Bloodshot", false, 7.1,
                2041, EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,"/ww7eC3BqSbFsyE5H5qMde8WkxJ2.jpg", mutableListOf(28, 27, 878, 53),443791,"en",
                "Underwater", "After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.",
                137.602,"/gzlbb3yeVISpQ3REd3Ga1scWGTU.jpg", "2020-01-08", "Underwater", false,
                6.4, 1000, EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,"/x80ZIVGUJ6plcUBcgVZ6DPKT7vc.jpg", mutableListOf( 14, 27, 878),539537,"en",
                "Fantasy Island", "A group of contest winners arrive at an island hotel to live out their dreams, only to find themselves trapped in nightmare scenarios.",
                139.542,"/8ZMrZGGW65ePWIgRn1260nA1uUm.jpg", "2020-02-12", "Fantasy Island", false,
                6.0, 570, EnumConfig.typeMovie
            )
        )

        listMovie.add(
            Result(
                false,"/9sXHqZTet3Zg5tgcc0hCDo8Tn35.jpg", mutableListOf( 12, 18, 10751),481848,"en",
                "The Call of the Wild", "Buck is a big-hearted dog whose blissful domestic life is turned upside down when he is suddenly uprooted from his California home and transplanted to the exotic wilds of the Yukon during the Gold Rush of the 1890s. As the newest rookie on a mail delivery dog sled team—and later its leader—Buck experiences the adventure of a lifetime, ultimately finding his true place in the world and becoming his own master.",
                166.974,"/33VdppGbeNxICrFUtW2WpGHvfYc.jpg", "2020-02-19", "The Call of the Wild", false,
                7.2, 776, EnumConfig.typeMovie
            )
        )


        return Resource.success(NPMovieApi(Dates("2020-05-03", "2020-03-16"), 1, listMovie, 774, 39))
    }

    fun generateTvShow(): Resource<OATvShowApi> {
        val listTvShow = mutableListOf<com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result>()

        listTvShow.add((com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result(
            "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg", "2014-10-07", mutableListOf(18,10765), 60735,
            "The Flash", mutableListOf("US"), "en", "The Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            220.57, "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", 7.2,4213, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result(
            "/eV3XnUul4UfIivz3kxgeIozeo50.jpg", "2013-12-02", mutableListOf(16, 35, 10765),
            60625, "Rick and Morty", mutableListOf("US"), "en", "Rick and Morty",
            "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
            126.141, "/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg", 8.7, 2230, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result(
            "/5zS9trn5k6T6Oew85ZIEKUfRo91.jpg", "The Simpsons", mutableListOf(16, 35),
            456, "The Simpsons", mutableListOf("US"), "en", "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
        ,101.435, "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg", 7.4, 3184, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result(
            "/8YWQ1JrA4fihMwf9kYvGtd6mSe0.jpg", "2013-09-23", mutableListOf(80, 18, 9648), 46952,
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
            mutableListOf("US"), "en", "The Blacklist",
            "Raymond \\\"Red\\\" Reddington, one of the FBI's most wanted fugitives, surrenders in person at FBI Headquarters in Washington, D.C. He claims that he and the FBI have the same interests: bringing down dangerous criminals and terrorists. In the last two decades, he's made a list of criminals and terrorists that matter the most but the FBI cannot find because it does not know they exist. Reddington calls this \\\"The Blacklist\\\". Reddington will co-operate, but insists that he will speak only to Elizabeth Keen, a rookie FBI profiler."
        ,94.216, "/bgbQCW4fE9b6wSOSC6Fb4FfVzsW.jpg", 7.1, 1330, EnumConfig.typeTvShow
        )))

        listTvShow.add((com.programmergabut.moviecatalogue.data.model.json.oatvshow.Result(
            "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg", "2017-01-26", mutableListOf(18),
            69050, "Riverdale", mutableListOf("US"), "en", "Riverdale",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            82.418, "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg", 8.3, 2135, EnumConfig.typeTvShow
        )))


        return Resource.success(OATvShowApi(1, listTvShow, 22, 433))
    }
}