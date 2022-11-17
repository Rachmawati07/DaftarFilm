package com.rachma.daftarfilm

import com.google.gson.annotations.SerializedName

// 5. Bagian class data
// Untuk mendeklarasikan class yang bernama Movie
data class Movie(
    // Untuk mendeklarasikan nama serial yang bernama Title sebagai variabel title dan mempunyai tipe data berupa string
    @SerializedName("Title") val title: String,
    // Untuk mendeklarasikan nama serial yang bernama Poster sebagai variabel poster dan mempunyai tipe data berupa string
    @SerializedName("Poster") val poster: String,
    // Untuk mendeklarasikan variabel yang bernama imdbId dengan tipe data berupa string
    val imdbID: String,
    // Untuk mendeklarasikan nama serial yang bernama Year sebagai variabel year dan mempunyai tipe data berupa string
    @SerializedName("Year") val year: String
)
