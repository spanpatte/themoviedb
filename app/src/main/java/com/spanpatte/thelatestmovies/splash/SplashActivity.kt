package com.spanpatte.thelatestmovies.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.spanpatte.thelatestmovies.moviefeature.presentation.views.MovieListViewActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@SplashActivity, MovieListViewActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
