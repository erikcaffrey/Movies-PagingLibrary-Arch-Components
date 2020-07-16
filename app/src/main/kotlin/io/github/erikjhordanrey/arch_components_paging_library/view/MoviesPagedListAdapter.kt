package io.github.erikjhordanrey.arch_components_paging_library.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import io.github.erikjhordanrey.arch_components_paging_library.R
import io.github.erikjhordanrey.arch_components_paging_library.data.room.Movie

class MoviesPagedListAdapter(val clickListener: (Movie) -> Unit) : PagedListAdapter<Movie, MoviesViewHolder>(movieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.render(movie) else holder.clear()

        holder.itemView.setOnClickListener {
            movie?.let { movie -> clickListener(movie) }
        }
    }

    companion object {
        private val movieDiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.popularity == newItem.popularity &&
                        oldItem.voteAverage == newItem.voteAverage && oldItem.posterUrl == newItem.posterUrl &&
                        oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}
