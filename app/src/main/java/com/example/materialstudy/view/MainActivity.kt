package com.example.materialstudy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityMainBinding
import com.example.materialstudy.view.bottomsheet.BottomsheetActivity
import com.example.materialstudy.view.chips.ChipsActivity
import com.example.materialstudy.view.motion.MotionActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.motionButton.setOnClickListener {
            startActivity(Intent(this, MotionActivity::class.java))
        }

        binding.chipsButton.setOnClickListener {
            startActivity(Intent(this, ChipsActivity::class.java))
        }

        binding.bottomsheetButton.setOnClickListener {
            startActivity(Intent(this, BottomsheetActivity::class.java))
        }
    }
}
