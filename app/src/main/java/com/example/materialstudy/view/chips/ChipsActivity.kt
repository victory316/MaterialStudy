package com.example.materialstudy.view.chips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.databinding.ActivityChipsBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import timber.log.Timber

class ChipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChipsBinding

    private var chipIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChipsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.addChipButton.setOnClickListener {

            Timber.d("adding chip! : $chipIndex")
            val chip = Chip(this)
            chip.text = "Chip $chipIndex"

            chipIndex++

            binding.chipGroup.addView(chip)
            binding.chipGroup.invalidate()
        }
    }
}
