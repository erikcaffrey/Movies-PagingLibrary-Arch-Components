package io.github.erikjhordanrey.arch_components_paging_library.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.erikjhordanrey.arch_components_paging_library.R
import io.github.erikjhordanrey.arch_components_paging_library.data.room.Movie
import kotlinx.android.synthetic.main.item_movie.view.image

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun render(movie: Movie) = itemView.run {
        Glide.with(image.context)
                .load(movie.posterUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
    }

    fun clear() = itemView.run {
        image.invalidate()
    }
}
