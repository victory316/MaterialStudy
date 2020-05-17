package com.example.materialstudy.view.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityBottomNavBinding

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
        var badge = binding.bottomNavigation.getOrCreateBadge(R.id.page_1)
        badge.isVisible = true
// An icon only badge will be displayed unless a number is set:
//        badge.number = 99
    }

    private fun setupNavMenu() {
        binding.bottomNavigation.setOnNavigationItemReselectedListener {item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    binding.bottomNavigation.removeBadge(R.id.page_1)
                }
                R.id.page_2 -> {}
                R.id.page_3 -> {}
            }
        }
    }
}
