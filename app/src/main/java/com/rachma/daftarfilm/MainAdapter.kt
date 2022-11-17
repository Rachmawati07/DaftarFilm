package com.rachma.daftarfilm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rachma.daftarfilm.databinding.LayoutRvItemBinding

// 3. Bagian Adapter
// Untuk mendeklarasikan class yang bernama MainAdapter
class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    // Untuk mendeklarasikan variabel yang bernama movies
    var movies = mutableListOf<Movie>()

    // Untuk mendeklarasikan fungsi yang bernama setMoviewList
    // Untuk memberitahu perubahan data
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    // Untuk memanggil kelas super onCreate dalam pembuatan activity ini
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        // Untuk mendeklarasikan variabel yang bernama inflater yang merupakan layout inflater dari parent
        val inflater = LayoutInflater.from(parent.context)
        // Untuk mendeklarasikan variabel binding untuk LayoutRvItemBinding
        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        // Untuk mengembalikan binding pada MainViewHolder
        return MainViewHolder(binding)
    }
    // 7. Bagian untuk parsing data json dengan menggunakan library glide dan untuk meload gambar poster
    // Untuk mendeklarasikan fungsi onBindViewHolder dalam pembuatan activity ini
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        // Untuk mendeklarasikan variabel yang bernama  moview
        val movie = movies[position]
        // Untuk mendapatkan data binding yang berupa teks dari movie title
        holder.binding.movieTitle.text = movie.title
        // Untuk menggunakan perpustakaan glide untuk memuat poster dari drawable kedalam moviewPoster
        Glide.with(holder.itemView.context).load(movie.poster).placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)

    }

    // Untuk mendeklarasikan fungsi yang bernama getItemCount
    override fun getItemCount(): Int {
        // Untuk mengembalikan ukuran dari movies
        return movies.size
    }
}

// Untuk mendeklarasikan class yang bernama MainViewHolder dan mendeklarasikan variabel binding untuk LayoutRvItemBinding menggunakan recyclerView
class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}