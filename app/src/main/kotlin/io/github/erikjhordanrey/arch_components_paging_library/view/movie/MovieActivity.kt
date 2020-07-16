package io.github.erikjhordanrey.arch_components_paging_library.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import io.github.erikjhordanrey.arch_components_paging_library.R
import io.github.erikjhordanrey.arch_components_paging_library.data.room.Movie
import io.github.erikjhordanrey.arch_components_paging_library.view.MoviesActivity.Companion.ARG_MOVIE
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(ARG_MOVIE)

        Glide.with(this)
                .load(movie.posterUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image)

        movie_title.text = movie.title
        movie_description.text = movie.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
