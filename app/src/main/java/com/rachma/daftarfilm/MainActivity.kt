package com.rachma.daftarfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rachma.daftarfilm.databinding.ActivityMainBinding
import com.rachma.daftarfilm.repository.MainRepository
import com.rachma.daftarfilm.viewmodel.MainViewModel

// 1. Bagian untuk class activity untuk view ke AcitivityMain dengan binding
// Untuk mendeklararasikan class yang bernama MainActivity
class MainActivity : AppCompatActivity() {

    // Untuk mendeklarasikan variabel yang bernama TAG yang berarti sama dengan MainActivity
    private val TAG = "MainActivity"
    // Untuk mendeklarasikan variabel binding untuk ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    // Untuk mendeklarasikan variabel yang bernama viewModel untuk MainViewModel
    lateinit var viewModel: MainViewModel

    // Untuk mendeklarasikan variabel yang bernama retrofitService
    private val retrofitService = RetrofitService.getInstance()
    // Untuk mendeklarasikan variabel yang bernama adapter yang sama dengan MainAdapter
    val adapter = MainAdapter()

    // Untuk memanggil kelas super onCreate dalam pembuatan activity ini
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Untuk memanggil ActivityMainBinding dengan menggunakan binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Untuk mendapatkan instance viewmodel menggunakan ViewModelProviderFactory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        // Untuk mengatur adaptor di recyclerview dengan binding
        binding.recyclerview.adapter = adapter

        // Observer hanya akan menerima acara jika pemilik (aktivitas) dalam keadaan aktif
        // Dan akan dipanggil saat data movieList berubah
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        // Akan menampilkan pesan error saat pengecualian jaringan terjadi
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        // Untuk mendapatkan semua data di viewModel
        viewModel.getAllMovies()
    }
}