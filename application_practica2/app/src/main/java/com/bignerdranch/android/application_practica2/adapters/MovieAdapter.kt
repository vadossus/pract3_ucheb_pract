package com.bignerdranch.android.application_practica2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.application_practica2.adapters.MovieAdapter.*
import com.bignerdranch.android.application_practica2.databinding.FragmentMovieBinding
import com.bignerdranch.android.application_practica2.databinding.MovieItemBinding
import com.bignerdranch.android.application_practica2.ui.models.Movie
import com.bignerdranch.android.application_practica2.ui.notifications.MovieFragment

class MovieAdapter(private var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{
    private lateinit var _context: Context
    private var items: List<Movie> = movies

    class ViewHolder(binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        val MovieImage = binding.movieName
        val MovieRating = binding.movieRating
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.sortedByDescending { it.rating }[position]
        holder.MovieImage.text = item.movie
        holder.MovieRating.text = item.rating.toString()
    }

    fun updateMovie(items: List<Movie>){
        this.items = items
        notifyDataSetChanged()
    }
}