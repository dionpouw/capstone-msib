package com.aldion.capstonemsib

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.capstonemsib.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {
    private var binding: ActivitySplashBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        runBlocking{
            launch{
                delay(2000L)
                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }

        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}