package com.example.materialstudy.view.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityBottomNavBinding
import com.example.materialstudy.util.InjectorUtils
import com.example.materialstudy.viewmodel.BottomNavViewModel

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)

        setupBadges()
        setupNavMenu()

        setContentView(binding.root)
    }

    private fun setupBadges() {

        with(binding.bottomNavigation) {

            getOrCreateBadge(R.id.page_1).apply {
                isVisible = true
            }

            getOrCreateBadge(R.id.page_2).apply {
                isVisible = true
                number = 35
            }

            getOrCreateBadge(R.id.page_3).apply {
                isVisible = true
                number = 1500
            }
        }
    }

    private fun setupNavMenu() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    binding.bottomNavigation.removeBadge(R.id.page_1)
                }
                R.id.page_2 -> {
                    binding.bottomNavigation.removeBadge(R.id.page_2)
                }
                R.id.page_3 -> {
                    binding.bottomNavigation.removeBadge(R.id.page_3)
                }
            }

            true
        }
    }
}
