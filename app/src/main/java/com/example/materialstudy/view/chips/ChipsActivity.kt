package com.example.materialstudy.view.chips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.databinding.ActivityChipsBinding

class ChipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChipsBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
