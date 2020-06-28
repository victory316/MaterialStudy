package com.example.materialstudy.util

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialstudy.data.BottomNavRepository
import com.example.materialstudy.data.local.MainDatabase
import com.example.materialstudy.viewmodel.BottomNavViewModelFactory

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

    fun provideMotionViewModel(fragment: Fragment): BottomNavViewModelFactory{
        val repository = getMainRespository(fragment.requireContext())
        return BottomNavViewModelFactory(repository, fragment)
    }

    fun provideBottomViewModel(fragment: Fragment): BottomNavViewModelFactory{
        val repository = getMainRespository(fragment.requireContext())
        return BottomNavViewModelFactory(repository, fragment)
    }

    fun provideBottomViewModelOnActivity(activity: AppCompatActivity): BottomNavViewModelFactory{
        val repository = getMainRespository(activity.application.applicationContext)
        return BottomNavViewModelFactory(repository, activity)
    }
}