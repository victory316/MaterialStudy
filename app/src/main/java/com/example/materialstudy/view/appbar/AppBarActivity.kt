package com.example.materialstudy.view.appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityAppBarBinding

class AppBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBarBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
