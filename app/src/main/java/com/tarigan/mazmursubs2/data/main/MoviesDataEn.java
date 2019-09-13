package com.tarigan.mazmursubs2.data.main;

import com.tarigan.mazmursubs2.Model.Movie;

import java.util.ArrayList;

public class MoviesDataEn {
    public static String[][] data = new String[][]{
            {"Night Shift","After a chance meeting in a hotel years later, two men reignite an incendiary relationship forged by their mysterious shared past.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/fL6VYpgfsnTyrXAASgxPrK4kBHy.jpg"},
            {"The Bits of Yesterday","In this panoptic documentary on the niche culture of the retro video game collector, follow gaming enthusiasts and fans as they relive their childhood memories, make new ones and champion to keep an antiquated media…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/7kKATLF6rTpXhzR1sTE3yTWbLVs.jpg"},
            {"The Partys Just Beginning","n a bleak Inverness midwinter, Luisaidh is careening off the rails after the suicide of her best friend. She medicates her misery with joyless sex, chips and a belief in the power of positive drinking. Surrounded…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/dkQGIm3g4gQIm6sme3P1cHHexnt.jpg"},
            {"Intangible","The tangible benefits of watching this film may be in allowing the intangible to enable changes in mood and perspective.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/yhGrt2eN72NjBQ7c2d6QUG10rYv.jpg"},
            {"Tergantung Rindu","The story of two siblings apart from the debts of their uncle trying to meet again They collect money by becoming street musicians.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/poRYRCf1dBqh196S0YYPXhcc0p8.jpg"},
            {"Karma","A social drama that deals with the tense relationship between Muslims and Christians, through the story of a young Muslim who falls in love with a Christian girl and marries her despite the objection of everyone.…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/2hcJsAyl9MMd2cKJD6raBEJ8N7I.jpg"},
            {"The Wrong Son","Thirteen years after disappearing and presumed drowned, Matt returns home to his mother Sarah. Suspicions grow when her older son Ian is injured in a car accident similar to the one that recently killed his father.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/sP7kgRFMRTI7O2GQ7Zia5HcUWjr.jpg"},
            {"Mile Marker","Mile Marker\", focuses on a two-tour veteran of Afghanistan and Iraq, Korey Rowe, along with his former Rakkasan Brothers on their long road to recovery from PTSD. The Rakkasans were the invading force for both Middle…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/6QhOIWZexhHKcLgyEjDsdNChJbu.jpg"},
            {"Holmes & Watson","Detective Sherlock Holmes and Dr. John Watson join forces to investigate a murder at Buckingham Palace. They soon learn that they have only four days to solve the case, or the queen will become the next victim.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/orEUlKndjV1rEcWqXbbjegjfv97.jpg"},
            {"Crystal Swan","Minsk, Belarus, 1996. Velya, an aspiring DJ, wants to move to Chicago to make her dreams come true, but bureaucracy, a phone line and the human condition will put obstacles in her way that will be difficult to avoid.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/lq16a2Vyo7L2Tkh2oH6jlKLxZru.jpg"}
    };

    public static ArrayList<Movie> getListData(){
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] aData : data) {
            Movie movie = new Movie();
            movie.setName(aData[0]);
            movie.setDesc(aData[1]);
            movie.setPhoto(aData[2]);

            list.add(movie);
        }

        return list;
    }
}
