package com.tarigan.mazmursubs2.data.main;

import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

public class TvShowDataEn {
    public static String[][] data = new String[][]{
            {"The After Moon Show","We don't have an overview translated in English. Help us expand our database by adding one.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/9453BiD7iRUSDPl7j1um42WhDw8.jpg"},
            {"Ishq Tamasha","A story of five individuals and how love creates drama in their life. How their decisions have significant impact on each others lives.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/A2InvUD0P9LKdKoZsk8g6wUPv3Y.jpg"},
            {"Band Khirkiyan","Subuhi, a simple and sensitive girl, is married to Zain, an extremely possessive man. Their love vanishes with jealousy, doubts and suffocation, which overpowers their relationship.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/ba8DVQltr0XR5JUX5wKSLyVnr3p.jpg"},
            {"The Fix","Comedians Jimmy Carr, D.L. Hughley and Katherine Ryan tackle the world's woes with help from a rotating crew of funny guests and an actual expert.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/soXzI7IUQWHvFcG6pXgJX0DuRov.jpg"},
            {"Sando","Australia's discount furniture queen, Victoria 'Sando' Sandringham needs to reconnect with her family to revive her business and find personal redemption. The only problem is they mostly hate her. Mostly.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/y6NiAWdefYca9OaAOpT2kfsL3kG.jpg"},
            {"In Contempt","The procedural is set in the fast-paced world of a legal aid office in New York City and follows Gwen Sullivan, an opinionated attorney whose passion for her job and clients make her arguably the most talented public…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/A5yMexH4btpEA6on9jWD4kDnBK1.jpg"},
            {"Misty","When a popular anchorwoman for a prime time news show becomes the suspect in a murder case, her estranged husband - who has worked as a prosecutor in the past but now works as a public defender - decides to defend…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/5kqnPQJrbOiyT03OawvSAKnX1u5.jpg"},
            {"Lost in 1949","On New Year’s Day in 1949, female accountant Huang Li Wen returns to her hometown Shanghai in order to commemorate her husband and comrade’s death. As a Communist agent, she is ordered to obtain valuable information…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/qjPIKS8Lr9BOw842bOdiPI4acTO.jpg"},
            {"Mr. Right","Cheng Hao is a dentist who spends his free time helping others devise ways to get the girl of their dreams, despite the fact that he has never been in love. He meets Luo Yue who deals with jerks and heartbreakers.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/rkYbcJtm95nonOF8pvszZ4CngtJ.jpg"},
            {"The Switch","Just as the responsibility of a teacher, has resolved resentment Gypsy identity Ha Linh should gradually be exposed. Enemies seek to take advantage of school and the pupils used as bait to force Ha Linh must appear.…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/sqcA3jkU2FTRq2cSkvYxaTnq1Us.jpg"}
    };

    public static ArrayList<TvShow> getListData(){
        ArrayList<TvShow> list = new ArrayList<>();
        for (String[] aData : data) {
            TvShow tvShow = new TvShow();
            tvShow.setName(aData[0]);
            tvShow.setDesc(aData[1]);
            tvShow.setPhoto(aData[2]);

            list.add(tvShow);
        }

        return list;
    }
}
