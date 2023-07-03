package com.example.openpayexam.dashboard.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.openpayexam.dashboard.databinding.ItemMovieBinding
import com.example.openpayexam.entity_adapter.app.entity.movies.Movie

/** */
class MoviesAdapter(private val movies: List<Movie>)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater)
        return MovieViewHolder(binding)

    }

    /** */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    /** */
    override fun getItemCount() = movies.size

    /** */
    inner class MovieViewHolder(private val binding : ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        /* */
        fun bind(movie: Movie) {

            val imageUrl = "https://image.tmdb.org/t/p/original/${movie.poster_path}"

            Glide.with(binding.root)
                .load(imageUrl)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(binding.itemMovieIvMovie)

            binding.itemMovieTvTitle.text = movie.title
            binding.itemMovieTvSubtitle.text = movie.overview

        }

    }
}
