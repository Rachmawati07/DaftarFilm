package com.rachma.daftarfilm.repository

import com.rachma.daftarfilm.RetrofitService

// Untuk mendeklarasikan class yang bernama MainRepository dengan konstruktor yang bersifat privat untuk variabel retrofitService
class MainRepository constructor(private val retrofitService: RetrofitService) {

    // Untuk mendeklarasikan fungsi yang bernama getAllMoview untuk mendapatkan semua data dari retrofitService
    fun getAllMovies() = retrofitService.getAllMovies()
}