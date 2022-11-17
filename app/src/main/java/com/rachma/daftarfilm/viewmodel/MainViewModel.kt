package com.rachma.daftarfilm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rachma.daftarfilm.Movie
import com.rachma.daftarfilm.model.MovieList
import com.rachma.daftarfilm.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Untuk mendeklarasikan class yang bernama MainViewModel dan juga mendeklarasikan variabel yang bersifat privat yaitu repository yang merupakan MainRepository
class MainViewModel(private val repository: MainRepository) : ViewModel() {

    // Untuk mendeklarasikan variabel yang bernama moviewList yang merupakan bagian dari live data
    val movieList = MutableLiveData<List<Movie>>()
    // Untuk mendeklarasikan variabel yang bernama errorMessage yang merupakan bagian dari live data
    val errorMessage = MutableLiveData<String>()

    // Untuk mendeklarasikan fungsi yang bernama getAllMovies
    fun getAllMovies() {

        // Untuk mendeklarasikan variabel yang bernama response yang merupakan repository untuk mendapatkan semua data
        val response = repository.getAllMovies()
        // Untuk memanggil kembali respon dari MovieList
        response.enqueue(object : Callback<MovieList> {
            // Untuk mendeklarasikan fungsi yang bernama onResponse untuk memanggil MovieList
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                movieList.postValue(response.body()?.mList)
            }

            // Untuk mendeklarasikan fungsi yang bernama onFailure dengan memanggil MovieList dan jika ada yang gagal maka akan melempar pesan kesalahan
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}