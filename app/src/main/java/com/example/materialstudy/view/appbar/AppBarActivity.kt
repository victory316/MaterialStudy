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

//    fun setupUI() {
//        binding.topAppBar.setOnMenuItemClickListener {menuItem ->
//            when (menuItem.itemId) {
//                R.id.favorite -> {
//                    // Handle favorite icon press
//                    true
//                }
//                R.id.search -> {
//                    // Handle search icon press
//                    true
//                }
//                R.id.more -> {
//                    // Handle more item (inside overflow menu) press
//                    true
//                }
//                else -> false
//            }
//        }
//    }
}
