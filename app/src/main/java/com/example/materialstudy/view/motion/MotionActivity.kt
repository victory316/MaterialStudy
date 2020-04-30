package com.example.materialstudy.view.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityMotionBinding

class MotionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_motion)

        setFirstFragment()
    }

    private fun setFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFrameLayout.id, MotionHomeFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun changeFragment(fragment: Fragment) {

    }
}
