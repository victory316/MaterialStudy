package com.example.materialstudy.view.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityBottomsheetBinding

class BottomsheetActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomsheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomsheetBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
