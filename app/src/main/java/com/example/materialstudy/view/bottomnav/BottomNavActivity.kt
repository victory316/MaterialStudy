package com.example.materialstudy.view.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.databinding.ActivityBottomNavBinding

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
