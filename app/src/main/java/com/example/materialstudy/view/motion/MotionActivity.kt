package com.example.materialstudy.view.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) finish()

        super.onBackPressed()
    }

    private fun setFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFrameLayout.id, MotionHomeFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun changeFragment(view: View, sharedElementName: String, endFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addSharedElement(view, sharedElementName)
            .replace(binding.mainFrameLayout.id, endFragment, endFragment.tag)
            .addToBackStack(endFragment.tag)
            .commit()
    }
}
