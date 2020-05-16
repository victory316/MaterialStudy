package com.example.materialstudy.view.chips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.databinding.ActivityChipsBinding
import com.google.android.material.chip.Chip

class ChipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChipsBinding

    private var chipIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChipsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.addChipButton.setOnClickListener {

            val chip = Chip(this).apply {
                text = "Chip $chipIndex"
                isCloseIconVisible = true

                setOnCloseIconClickListener {
                    binding.chipGroup.removeView(this)
                }
            }

            chipIndex++

            binding.chipGroup.addView(chip)
            binding.chipGroup.invalidate()
        }
    }
}
