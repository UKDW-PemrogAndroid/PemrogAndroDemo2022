package com.pemrogandroid.movieku.ui.addmovie

class AddMovieContract {

    interface PresenterInterface {
        fun addMovie(id: Int, title: String, releaseDate: String, posterPath: String)
    }

    interface ViewInterface {

        fun returnToMain()
        fun displayMessage(message : String)

        fun displayError(meesage : String)
    }
}