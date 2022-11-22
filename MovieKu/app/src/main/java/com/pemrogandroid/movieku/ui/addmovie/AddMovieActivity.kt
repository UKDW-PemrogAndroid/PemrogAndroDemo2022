package com.pemrogandroid.movieku.ui.addmovie

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.pemrogandroid.movieku.databinding.ActivityAddMovieBinding
import com.pemrogandroid.movieku.ui.search.SearchActivity

class AddMovieActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddMovieBinding
    private lateinit var activitySearchLaucher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activitySearchLaucher = registerForActivityResult(
            ActivityResultContracts
                .StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {

            }
        }

        binding.searchButton.setOnClickListener({
            goToSearchMovieActivity()
        })
    }

    private fun goToSearchMovieActivity() {
        val intent = Intent(this@AddMovieActivity, SearchActivity::class.java)
        activitySearchLaucher.launch(intent)
    }
}