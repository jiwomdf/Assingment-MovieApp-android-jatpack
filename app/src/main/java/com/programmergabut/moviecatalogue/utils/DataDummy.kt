package com.programmergabut.moviecatalogue.utils

import com.programmergabut.moviecatalogue.data.model.json.genre.Genre
import com.programmergabut.moviecatalogue.data.model.json.npmovie.Dates
import com.programmergabut.moviecatalogue.data.model.json.npmovie.NPMovieApi
import com.programmergabut.moviecatalogue.data.model.json.npmovie.Result
import com.programmergabut.moviecatalogue.data.model.local.Movie
import com.programmergabut.moviecatalogue.data.model.local.TvShow

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

object DataDummy{

    fun generateMovie(): Resource<NPMovieApi> {
        val listMovie = mutableListOf<Result>()

        listMovie.add(
            Result(
                false,"/ocUrMYbdjknu2TwzMHKT9PBBQRw.jpg", mutableListOf(28,878),338762,"en",
                "Bloodshot", "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
                189.831,"/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg", "2020-03-05", "Bloodshot", false, 7.1,
                2041, 1
            )
        )

        listMovie.add(
            Result(
                false,"/mUhh8glXvRfRIpX6jiUctEvg4IB.jpg", mutableListOf(28, 35, 878, 10751),454626,"en",
                "Sonic the Hedgehog", "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                212.138,"/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg", "2020-02-12", "Sonic the Hedgehog", false,
                7.5, 3511, 1
            )
        )

        listMovie.add(
            Result(
                false,"/ww7eC3BqSbFsyE5H5qMde8WkxJ2.jpg", mutableListOf(28, 27, 878, 53),443791,"en",
                "Underwater", "After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.",
                137.602,"/gzlbb3yeVISpQ3REd3Ga1scWGTU.jpg", "2020-01-08", "Underwater", false,
                6.4, 1000, 1
            )
        )

        listMovie.add(
            Result(
                false,"/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg", mutableListOf(35, 18, 53),496243,"en",
                "기생충", "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                110.915,"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg", "2019-05-30", "Parasite", false,
                8.5, 6913, 1
            )
        )

        listMovie.add(
            Result(
                false,"/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg", mutableListOf(35, 18, 53),496243,"en",
                "기생충", "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                110.915,"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg", "2019-05-30", "Parasite", false,
                8.5, 6913, 1
            )
        )


        return Resource.success(NPMovieApi(Dates("2020-05-03", "2020-03-16"), 1, listMovie, 774, 39))
    }

    fun generateTvShow(): List<TvShow>{
        val listTvShow = mutableListOf<TvShow>()

        listTvShow.add((TvShow(
            1, "Thieves of the Wood", 2,
            "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
            "Drama, Action & Adventure, Mystery", 59, "NETFLIX"
        )))

        listTvShow.add((TvShow(
            2, "My Girlfriend is an Alien", 2,
            "The alien girl Chai Xiaoqi tells the story of Fang Xiaoqi, the overbearing president of the alien girl who died from the \"Cape Town Planet\", who was suffering from the \"rainy weather heterosexual amnesia\". A high-energy hilarious and romantic cross-star love story. The female host Chai Xiaoqi is not only an alien, but also a true-handed witch. Once she inhales the hormones emitted by the males in the earth, she will fall into the \"flowery state\" and suffer from various diseases. The fun and ridiculously ridiculous romance will restore the singularity of the girl in the perfection of the girl. In order to survive on the human earth, Chai Xiaoqi will use his various super powers to solve one accident after another, like a roller coaster. The ups and downs will make the audience hooked. The male lord is cold and is an alternative overbearing president. When it rains, he will forget the opposite sex that appears around him. For this reason, he and the female host will launch various \"fighting and fighting\" laughter dramas. The experience of high sweetness and romance is expected to be Strongly slammed the girl's heart when it was broadcast.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5e2owvs9TWVsuIacTFxJGPp6KVW.jpg",
            "Comedy, Sci-Fi & Fantasy", 78, "Tencent Video"
        )))

        listTvShow.add((TvShow(
            3, "Money Heist", 2,
            "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
            "Crime, Drama", 85, "NETFLIX"
        )))

        listTvShow.add((TvShow(
            4, "Law & Order: Special Victims Unit", 2,
            "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
            "Crime, Drama", 85, "NBC"
        )))

        listTvShow.add((TvShow(
            5, "Westworld", 2,
            "A dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y55oBgf6bVMI7sFNXwJDrSIxPQt.jpg",
            "Western, Science Fiction", 85, "HBO"
        )))

        listTvShow.add((TvShow(
            6, "The Flash", 2,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
            "Drama, Sci-Fi & Fantasy", 72, "The CW"
        )))

        listTvShow.add((TvShow(
            7, "The Red Tent", 2,
            "Her name is Dinah. In the Bible her life is only hinted at during a brief and violent detour within the more familiar chapters about her father, Jacob, and his dozen sons in the Book of Genesis. Told through Dinah's eloquent voice, this sweeping miniseries reveals the traditions and turmoil of ancient womanhood. Dinah's tale begins with the story of her mothers: Leah, Rachel, Zilpah, and Bilhah, the four wives of Jacob. They love Dinah and give her gifts that are to sustain her through a hard-working youth, a calling to midwifery, and a new home in a foreign land. Dinah tells us of the world of the red tent, the place where women were sequestered during their cycles of birthing, menses, and illness; of her initiations into the religious and sexual practices of her tribe; of Jacob's courtship with his four wives; of the mystery and wonder of caravans, farmers, shepherds, and slaves; of love and death in the city of Shechem; of her half-brother Joseph's rise in Egypt, and of course her marriage to Shechem and it's bloody consequences.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/eZffDwKkM8hO0gbzOXrQ1eyKhkx.jpg",
            "Action & Adventure, Drama", 72, "Lifetime"
        )))

        listTvShow.add((TvShow(
            8, "The Red Tent", 2,
            "Set up to take the blame for corporate fraud, young Macarena Ferreiro is locked up in a high-security women's prison surrounded by tough, ruthless criminals in this tense, provocative Spanish thriller.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7mfPWKrNInkTbjVwp0EkaFYRHqD.jpg",
            "Drama", 81, "Lifetime"
        )))

        listTvShow.add((TvShow(
            9, "The Simpsons", 2,
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
            "Animation, Comedy", 74, "FOX"
        )))

        listTvShow.add((TvShow(
            10, "Vis a Vis: El Oasis", 2,
            "After a few years dedicating themselves to robbing jewelers, banks and casinos, it is time for Macarena and Zulema to separate.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7EOWkNGxXq2MBZxfV3ZxjRM4vlH.jpg",
            "Drama", 80, "FOX"
        )))

        return listTvShow
    }
}