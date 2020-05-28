package com.example.materialstudy.util

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.materialstudy.data.MaterialRepository
import com.example.materialstudy.viewmodel.MotionViewModelFactory

/**
 *
 *  InjectorUtils
 *
 *  - Database와 viewModel의 Injection을 돕는 class
 *
 */

object InjectorUtils {
    private fun getGithubRepository(context: Context): MaterialRepository {
        return MaterialRepository.getInstance()
    }

    fun provideMotionViewModel(fragment: Fragment): MotionViewModelFactory{
        val repository = getGithubRepository(fragment.requireContext())
        return MotionViewModelFactory(repository, fragment)
    }

    fun provideBottomViewModel(fragment: Fragment): MotionViewModelFactory{
        val repository = getGithubRepository(fragment.requireContext())
        return MotionViewModelFactory(repository, fragment)
    }
}