package com.tarigan.mazmursubs2.data.main;

import com.tarigan.mazmursubs2.model.TvShow;

import java.util.ArrayList;

public class TvShowDataIndo {
    public static String[][] data = new String[][]{
            {"The After Moon Show","Kami tidak memiliki ikhtisar yang diterjemahkan dalam bahasa Inggris. Bantu kami memperluas basis data kami dengan menambahkan satu.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/9453BiD7iRUSDPl7j1um42WhDw8.jpg"},
            {"Ishq Tamasha","Sebuah kisah lima individu dan bagaimana cinta menciptakan drama dalam kehidupan mereka. Bagaimana keputusan mereka memiliki dampak yang signifikan terhadap kehidupan satu sama lain.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/A2InvUD0P9LKdKoZsk8g6wUPv3Y.jpg"},
            {"Band Khirkiyan","Subuhi, seorang gadis yang sederhana dan sensitif, menikah dengan Zain, seorang pria yang sangat posesif. Cinta mereka lenyap dengan kecemburuan, keraguan dan mati lemas, yang mengalahkan hubungan mereka.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/ba8DVQltr0XR5JUX5wKSLyVnr3p.jpg"},
            {"The Fix","Komedian Jimmy Carr, D.L. Hughley dan Katherine Ryan mengatasi kesengsaraan dunia dengan bantuan dari kru berputar tamu lucu dan ahli yang sebenarnya.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/soXzI7IUQWHvFcG6pXgJX0DuRov.jpg"},
            {"Sando","Ratu furnitur diskon Australia, Victoria 'Sando' Sandringham perlu terhubung kembali dengan keluarganya untuk menghidupkan kembali bisnisnya dan menemukan penebusan pribadi. Satu-satunya masalah adalah mereka kebanyakan membencinya. Kebanyakan.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/y6NiAWdefYca9OaAOpT2kfsL3kG.jpg"},
            {"In Contempt","Prosedural ini diatur dalam dunia yang serba cepat dari kantor bantuan hukum di New York City dan mengikuti Gwen Sullivan, seorang pengacara yang memiliki hasrat untuk pekerjaannya dan klien membuatnya menjadi publik yang paling berbakat ...","https://image.tmdb.org/t/p/w600_and_h900_bestv2/A5yMexH4btpEA6on9jWD4kDnBK1.jpg"},
            {"Misty","Ketika seorang pembawa berita wanita yang terkenal untuk acara berita utama waktu menjadi tersangka dalam kasus pembunuhan, suaminya yang sudah terasing - yang telah bekerja sebagai jaksa di masa lalu tetapi sekarang bekerja sebagai pembela umum - memutuskan untuk membela ...","https://image.tmdb.org/t/p/w600_and_h900_bestv2/5kqnPQJrbOiyT03OawvSAKnX1u5.jpg"},
            {"Lost in 1949","Pada Hari Tahun Baru pada tahun 1949, akuntan wanita Huang Li Wen kembali ke kota asalnya Shanghai untuk memperingati kematian suaminya dan kawannya. Sebagai agen Komunis, dia diperintahkan untuk mendapatkan informasi berharga ...","https://image.tmdb.org/t/p/w600_and_h900_bestv2/qjPIKS8Lr9BOw842bOdiPI4acTO.jpg"},
            {"Mr. Right","Cheng Hao adalah seorang dokter gigi yang menghabiskan waktu luangnya untuk membantu orang lain menemukan cara untuk mendapatkan gadis impian mereka, terlepas dari kenyataan bahwa ia tidak pernah jatuh cinta. Dia bertemu Luo Yue yang berurusan dengan tersentak dan patah hati.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/rkYbcJtm95nonOF8pvszZ4CngtJ.jpg"},
            {"The Switch","Sama seperti tanggung jawab seorang guru, telah menyelesaikan kebencian identitas Gipsi Ha Linh secara bertahap harus diekspos. Musuh berusaha memanfaatkan sekolah dan murid yang digunakan sebagai umpan untuk memaksa Ha Linh harus muncul.…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/sqcA3jkU2FTRq2cSkvYxaTnq1Us.jpg"}
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
