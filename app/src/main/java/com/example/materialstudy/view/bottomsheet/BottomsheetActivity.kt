package com.example.materialstudy.view.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomsheetActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomsheetBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomsheetBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupBottomsheet()
    }

    private fun setupBottomsheet() {
        bottomSheetBehavior = (BottomSheetBehavior.from(binding.contentLayout)
                as BottomSheetBehavior<View>)
            .apply {

                isHideable = false
                state = BottomSheetBehavior.STATE_COLLAPSED
                isFitToContents = true

                addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                        binding.closeButton.alpha = slideOffset
                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {

                    }

                })
            }

        binding.closeButton.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}
