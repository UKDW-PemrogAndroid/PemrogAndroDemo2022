package com.pemrogandroid.movieku.ui.addmovie

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pemrogandroid.movieku.model.Movie
import com.pemrogandroid.movieku.repository.LocalDataSource

class AddMoviePresenter(
    private var viewInterface: AddMovieContract.ViewInterface,
    private var datasource: LocalDataSource
) : AddMovieContract.PresenterInterface {
    override fun addMovie(id: Int, title: String, releaseDate: String, posterPath: String) {
        if (id == null) {
            viewInterface.displayError("Movie belum dipilih")
        } else {
            val movie = Movie(id, title, releaseDate, posterPath)
            datasource.insert(movie)
            viewInterface.returnToMain()
        }
    }
}