package com.example.materialstudy.util

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialstudy.data.BottomNavRepository
import com.example.materialstudy.data.MaterialRepository
import com.example.materialstudy.data.local.MainDatabase
import com.example.materialstudy.viewmodel.MotionViewModelFactory

/**
 *
 *  InjectorUtils
 *
 *  - Database와 viewModel의 Injection을 돕는 class
 *
 */

object InjectorUtils {
//    private fun getGithubRepository(context: Context): MaterialRepository {
//        return MaterialRepository.getInstance(MainDatabase.getInstance(context.applicationContext)!!.mainDao())
//    }

    private fun getMainRespository(context: Context): BottomNavRepository {
        return BottomNavRepository.getInstance(MainDatabase.getInstance(context.applicationContext)!!.mainDao())
    }

    fun provideMotionViewModel(fragment: Fragment): MotionViewModelFactory{
        val repository = getMainRespository(fragment.requireContext())
        return MotionViewModelFactory(repository, fragment)
    }

    fun provideBottomViewModel(fragment: Fragment): MotionViewModelFactory{
        val repository = getMainRespository(fragment.requireContext())
        return MotionViewModelFactory(repository, fragment)
    }

    fun provideBottomViewModelOnActivity(activity: AppCompatActivity): MotionViewModelFactory{
        val repository = getMainRespository(activity.application.applicationContext)
        return MotionViewModelFactory(repository, activity)
    }
}