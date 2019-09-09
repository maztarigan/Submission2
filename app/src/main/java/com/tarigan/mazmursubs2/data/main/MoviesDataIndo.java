package com.tarigan.mazmursubs2.data.main;

import com.tarigan.mazmursubs2.Movie;

import java.util.ArrayList;

public class MoviesDataIndo {
    public static String[][] data = new String[][]{
            {"Regu Malam","Setelah pertemuan kebetulan di sebuah hotel bertahun-tahun kemudian, dua pria menyalakan kembali hubungan pembakar yang ditempa oleh masa lalu mereka yang misterius.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/fL6VYpgfsnTyrXAASgxPrK4kBHy.jpg"},
            {"The Bits of Yesterday","Dalam film dokumenter panoptik tentang budaya niche dari kolektor video game retro, ikuti penggemar game dan penggemar saat mereka menghidupkan kembali ingatan masa kecil mereka, buat yang baru dan juara untuk menjaga media kuno ...","https://image.tmdb.org/t/p/w600_and_h900_bestv2/7kKATLF6rTpXhzR1sTE3yTWbLVs.jpg"},
            {"Bagian Yang Baru Dimulai","Di tengah musim dingin yang suram di Inverness, Luisaidh meluncur dari rel setelah bunuh diri sahabatnya. Dia mengobati penderitaannya dengan seks yang tidak menyenangkan, keripik dan kepercayaan pada kekuatan minum yang positif. Terkepung…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/dkQGIm3g4gQIm6sme3P1cHHexnt.jpg"},
            {"Intangible","Manfaat nyata dari menonton film ini mungkin dalam memungkinkan hal yang tidak berwujud untuk memungkinkan perubahan suasana hati dan perspektif.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/yhGrt2eN72NjBQ7c2d6QUG10rYv.jpg"},
            {"Tergantung Rindu","Kisah dua saudara kandung terpisah dari hutang paman mereka yang berusaha bertemu lagi. Mereka mengumpulkan uang dengan menjadi musisi jalanan.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/poRYRCf1dBqh196S0YYPXhcc0p8.jpg"},
            {"Karma","Drama sosial yang membahas hubungan tegang antara Muslim dan Kristen, melalui kisah seorang Muslim muda yang jatuh cinta dengan seorang gadis Kristen dan menikahinya meskipun ada keberatan dari semua orang.…","https://image.tmdb.org/t/p/w600_and_h900_bestv2/2hcJsAyl9MMd2cKJD6raBEJ8N7I.jpg"},
            {"The Wrong Son","Tiga belas tahun setelah menghilang dan diduga tenggelam, Matt kembali ke rumah untuk ibunya, Sarah. Kecurigaan bertambah ketika putranya yang lebih tua, Ian, terluka dalam sebuah kecelakaan mobil mirip dengan yang baru-baru ini membunuh ayahnya.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/sP7kgRFMRTI7O2GQ7Zia5HcUWjr.jpg"},
            {"Mile Marker","Mile Marker berfokus pada veteran dua-tur Afghanistan dan Irak, Korey Rowe, bersama dengan mantan Rakkasan Brothers di jalan panjang mereka menuju pemulihan dari PTSD. The Rakkasans adalah kekuatan invasi untuk kedua Tengah ...","https://image.tmdb.org/t/p/w600_and_h900_bestv2/6QhOIWZexhHKcLgyEjDsdNChJbu.jpg"},
            {"Holmes & Watson","Detektif Sherlock Holmes dan Dr. John Watson bergabung untuk menyelidiki pembunuhan di Istana Buckingham. Mereka segera mengetahui bahwa mereka hanya memiliki empat hari untuk menyelesaikan kasus ini, atau sang ratu akan menjadi korban berikutnya.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/orEUlKndjV1rEcWqXbbjegjfv97.jpg"},
            {"Crystal Swan","Minsk, Belarusia, 1996. Velya, seorang DJ yang bercita-cita tinggi, ingin pindah ke Chicago untuk mewujudkan mimpinya, tetapi birokrasi, saluran telepon, dan kondisi manusia akan menempatkan hambatan dalam caranya yang sulit dihindari.","https://image.tmdb.org/t/p/w600_and_h900_bestv2/lq16a2Vyo7L2Tkh2oH6jlKLxZru.jpg"}
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
