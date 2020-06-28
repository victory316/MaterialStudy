package com.example.materialstudy.view.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.materialstudy.R
import com.example.materialstudy.databinding.ActivityBottomNavBinding
import com.example.materialstudy.util.InjectorUtils
import com.example.materialstudy.viewmodel.BottomNavViewModel
import timber.log.Timber

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    private val myNavViewModel: BottomNavViewModel by viewModels {
        InjectorUtils.provideBottomViewModelOnActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)

        setupBadges()
        setupNavMenu()
        setupFragment(FirstFragment.newInstance("ho", "ha"), "page_1")

        setupUi(binding)

        setContentView(binding.root)
    }

    private fun setupUi(binding: ActivityBottomNavBinding) {
        myNavViewModel.firstFragmentCount.observe(this, Observer { inputCount ->
            binding.bottomNavigation.getBadge(R.id.page_1)?.number = inputCount
        })
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
                    setupFragment(FirstFragment.newInstance("ho", "ha"), "page_1")

                    binding.bottomNavigation.removeBadge(R.id.page_1)
                }
                R.id.page_2 -> {
                    setupFragment(SecondFragment.newInstance("ho", "ha"), "page_2")

                    binding.bottomNavigation.removeBadge(R.id.page_2)
                }
                R.id.page_3 -> {
                    setupFragment(ThirdFragment.newInstance("ho", "ha"), "page_3")

                    binding.bottomNavigation.removeBadge(R.id.page_3)
                }
            }

            true
        }
    }

    private fun setupFragment(fragment: Fragment, tag: String) {
        Timber.d("fragment stack : ${supportFragmentManager.backStackEntryCount}")

        // 1. Fragment가 존재하지 않으면 새롭게 생성한다.
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.frameLayout.id, fragment, tag)
                .addToBackStack(tag)
                .commit()

            Timber.d("adding fragment : $fragment with tag $tag")
        } else {
            supportFragmentManager.popBackStack(tag, 0)

            Timber.d("popping fragment : $fragment with tag $tag")
        }

        // 2. Fragment가 존재할 경우 backstack에서 pop한다.

    }

    override fun onBackPressed() {
        finish()


        super.onBackPressed()
    }
}
