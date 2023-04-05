package com.seniorjavasky.harry_potter_and_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ActivityMainBinding
import com.seniorjavasky.harry_potter_and_retrofit.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}