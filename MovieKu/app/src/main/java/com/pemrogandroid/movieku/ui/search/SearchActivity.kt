package com.pemrogandroid.movieku.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.pemrogandroid.movieku.databinding.ActivitySearchMovieBinding

class SearchActivity: AppCompatActivity() {

    lateinit var binding: ActivitySearchMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}