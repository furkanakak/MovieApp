package com.furkan.movieapp.ui.movies

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkan.core.common.extension.extractYearWithFormatter
import com.furkan.core.common.extension.formatSingleDecimal
import com.furkan.core.common.extension.loadImage
import com.furkan.core.common.extension.log
import com.furkan.core.common.extension.toMoviePath
import com.furkan.core.data.entity.Movie
import com.furkan.movieapp.R
import com.furkan.movieapp.databinding.ItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: MutableList<Movie> = mutableListOf()
    var onItemClickListener: ((Movie) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapterList(movies: List<Movie>) {
        "setAdapterList" log "${movies.size}"
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    fun setAdapterItemClickListener(listener: (Movie) -> Unit) {
        onItemClickListener = listener
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                ivMovie.loadImage(movie.posterPath?.toMoviePath())
                tvTitle.text = movie.title
                tvDate.text = movie.releaseDate?.extractYearWithFormatter() ?: "-"
                tvRating.text = movie.voteAverage?.formatSingleDecimal()
                tvRating.setTextColor(
                    determineColorBasedOnRating(
                        movie.voteAverage.toString(),
                        root.context
                    )
                )
                tvMaxAverage.setTextColor(
                    determineColorBasedOnRating(
                        movie.voteAverage.toString(),
                        root.context
                    )
                )
                ivStar.setColorFilter(
                    determineColorBasedOnRating(
                        movie.voteAverage.toString(),
                        root.context
                    )
                )

                root.setOnClickListener {
                    onItemClickListener?.invoke(movie)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder =
        MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    fun determineColorBasedOnRating(rating: String, context: Context): Int {
        val ratingValue = rating.toDoubleOrNull() ?: return context.getColor(R.color.red)
        return when {
            ratingValue < 7 -> context.getColor(R.color.red)
            ratingValue in 7.0..9.0 -> context.getColor(R.color.orange)
            ratingValue > 9 -> context.getColor(R.color.green)
            else -> context.getColor(R.color.red)
        }
    }


}