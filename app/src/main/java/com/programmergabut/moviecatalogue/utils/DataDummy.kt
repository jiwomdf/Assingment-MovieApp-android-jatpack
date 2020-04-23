package com.programmergabut.moviecatalogue.utils

import com.programmergabut.moviecatalogue.data.Movie
import com.programmergabut.moviecatalogue.data.TvShow

/*
 *  Created by Katili Jiwo Adi Wiyono on 23/04/20.
 */

object DataDummy{

    fun generateMovie(): List<Movie>{
        val listMovie = mutableListOf<Movie>()

        listMovie.add(Movie(1,"Ad Astra",1,
            "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
            "Science Fiction, Drama", 60, "09/20/2019"))

        listMovie.add(Movie(2,"Underwater",1,
            "After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
             "Science Fiction, Drama", 64, "09/20/2019"))

        listMovie.add(Movie(3,"Sonic the Hedgehog",1,
            "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
            "Action, Science Fiction, Comedy, Family", 76, "02/14/2020"))

        listMovie.add(Movie(4,"Bad Boys for Life",1,
            "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
            "Thriller, Action, Crime\n", 72, "01/17/2020"))

        listMovie.add(Movie(5,"Star Wars: The Rise of Skywalker",1,
            "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
            "Action, Adventure, Science Fiction", 65, "12/20/2019"))

        listMovie.add(Movie(6,"Bloodshot",1,
            "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg",
            "Action, Science Fiction", 72, "03/13/2020"))

        listMovie.add(Movie(7,"Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)",1,
            "Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg",
            "Action, Crime, Comedy", 72, "02/07/2020"))

        listMovie.add(Movie(8,"Jumanji: The Next Level)",1,
            "As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world’s most dangerous game.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bB42KDdfWkOvmzmYkmK58ZlCa9P.jpg",
            "Adventure, Comedy, Fantasy", 69, "12/13/2019"))

        listMovie.add(Movie(9,"Mortal Kombat Legends: Scorpion’s Revenge",1,
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "Fantasy, Action, Adventure, Animation", 85, "04/12/2020"))

        listMovie.add(Movie(10,"Onward",1,
            "In a suburban fantasy world, two teenage elf brothers embark on an extraordinary quest to discover if there is still a little magic left out there.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/f4aul3FyD3jv3v4bul1IrkWZvzq.jpg",
            "Animation, Family, Adventure, Comedy, Fantasy", 80, "03/06/2020"))

        return listMovie
    }

    fun generateTvShow(): List<TvShow>{
        val listTvShow = mutableListOf<TvShow>()

        listTvShow.add((TvShow(1,"Thieves of the Wood",2,
        "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
        "Drama, Action & Adventure, Mystery",59, "NETFLIX")))

        listTvShow.add((TvShow(2,"My Girlfriend is an Alien", 2,
        "The alien girl Chai Xiaoqi tells the story of Fang Xiaoqi, the overbearing president of the alien girl who died from the \"Cape Town Planet\", who was suffering from the \"rainy weather heterosexual amnesia\". A high-energy hilarious and romantic cross-star love story. The female host Chai Xiaoqi is not only an alien, but also a true-handed witch. Once she inhales the hormones emitted by the males in the earth, she will fall into the \"flowery state\" and suffer from various diseases. The fun and ridiculously ridiculous romance will restore the singularity of the girl in the perfection of the girl. In order to survive on the human earth, Chai Xiaoqi will use his various super powers to solve one accident after another, like a roller coaster. The ups and downs will make the audience hooked. The male lord is cold and is an alternative overbearing president. When it rains, he will forget the opposite sex that appears around him. For this reason, he and the female host will launch various \"fighting and fighting\" laughter dramas. The experience of high sweetness and romance is expected to be Strongly slammed the girl's heart when it was broadcast.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5e2owvs9TWVsuIacTFxJGPp6KVW.jpg",
            "Comedy, Sci-Fi & Fantasy",78, "Tencent Video")))

        listTvShow.add((TvShow(3,"Money Heist", 2,
            "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
            "Crime, Drama",85, "NETFLIX")))

        listTvShow.add((TvShow(4,"Law & Order: Special Victims Unit",2,
        "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
            "Crime, Drama",85, "NBC")))

        listTvShow.add((TvShow(5,"Westworld", 2,
            "A dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y55oBgf6bVMI7sFNXwJDrSIxPQt.jpg",
            "Western, Science Fiction",85, "HBO")))

        listTvShow.add((TvShow(6,"The Flash", 2,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
            "Drama, Sci-Fi & Fantasy",72, "The CW")))

        listTvShow.add((TvShow(7,"The Red Tent", 2,
            "Her name is Dinah. In the Bible her life is only hinted at during a brief and violent detour within the more familiar chapters about her father, Jacob, and his dozen sons in the Book of Genesis. Told through Dinah's eloquent voice, this sweeping miniseries reveals the traditions and turmoil of ancient womanhood. Dinah's tale begins with the story of her mothers: Leah, Rachel, Zilpah, and Bilhah, the four wives of Jacob. They love Dinah and give her gifts that are to sustain her through a hard-working youth, a calling to midwifery, and a new home in a foreign land. Dinah tells us of the world of the red tent, the place where women were sequestered during their cycles of birthing, menses, and illness; of her initiations into the religious and sexual practices of her tribe; of Jacob's courtship with his four wives; of the mystery and wonder of caravans, farmers, shepherds, and slaves; of love and death in the city of Shechem; of her half-brother Joseph's rise in Egypt, and of course her marriage to Shechem and it's bloody consequences.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/eZffDwKkM8hO0gbzOXrQ1eyKhkx.jpg",
            "Action & Adventure, Drama",72, "Lifetime")))

        listTvShow.add((TvShow(8,"The Red Tent", 2,
            "Set up to take the blame for corporate fraud, young Macarena Ferreiro is locked up in a high-security women's prison surrounded by tough, ruthless criminals in this tense, provocative Spanish thriller.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7mfPWKrNInkTbjVwp0EkaFYRHqD.jpg",
            "Drama",81, "Lifetime")))

        listTvShow.add((TvShow(9,"The Simpsons", 2,
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
            "Animation, Comedy",74, "FOX")))

        listTvShow.add((TvShow(10,"Vis a Vis: El Oasis", 2,
            "After a few years dedicating themselves to robbing jewelers, banks and casinos, it is time for Macarena and Zulema to separate.",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7EOWkNGxXq2MBZxfV3ZxjRM4vlH.jpg",
            "Drama",80, "FOX")))

        return listTvShow
    }
}