package com.rachma.daftarfilm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rachma.daftarfilm.repository.MainRepository
import com.rachma.daftarfilm.viewmodel.MainViewModel

// Untuk mendeklarasikan class yang bernama myViewModelFactory dengan konstruktor yang bersifat privat untuk variabel repository yang merupakan MainRepository
class MyViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    // Untuk mendeklarasikan fungsi Viewodel dan membuat modelClass
    // Dan mengembalikan modelclass jika ditugaskan dari MainViewModel yang merupakan repository
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        // Namun jika salah maka akan menampilkan exception berupa ViewModel Not Found
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}