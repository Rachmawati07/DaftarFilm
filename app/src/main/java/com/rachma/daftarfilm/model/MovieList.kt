package com.rachma.daftarfilm.model

import com.rachma.daftarfilm.Movie
import com.google.gson.annotations.SerializedName

// Untuk mendeklarasikan class yang bernama MovieList
// Untuk mendeklarasikan nama serial dengan nilai search sebagai variabel mList
data class MovieList(@SerializedName("Search") val mList: List<Movie>)
