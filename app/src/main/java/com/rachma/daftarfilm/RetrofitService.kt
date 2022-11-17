package com.rachma.daftarfilm

import com.rachma.daftarfilm.model.MovieList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Untuk mendeklarasikan interface yang bernama RetrofirService
// Dan untuk mendapatkan data dari api?s=batman
interface RetrofitService {
    @GET("api?s=batman")
    // Untuk mendeklarasikan fungsi yang bernama getAllMovies untuk memanggil MovieList
    fun getAllMovies(): Call<MovieList>

    companion object {

        // Untuk mendeklarasikan variabel yang bernama retrofit dimana RetrofitService bisa bernilai null
        var retrofitService: RetrofitService? = null

        // Untuk membuat instance RetrofitService menggunakan retrofit.
        fun getInstance(): RetrofitService {

            // Jika retrofitService sama dengan null, maka akan mendeklarasikan variabel retrofit dan menggunakan method Builder
            // Untuk mengakses url dan membuat GsonConverterFactory
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://fake-movie-database-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                // Untuk membuat class RetrofitService
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            // Untuk mengembalikan retrofitService dan nilainya tidak boleh kosong
            return retrofitService!!
        }
    }
}