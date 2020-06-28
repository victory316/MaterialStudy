package com.example.materialstudy.viewmodel

import androidx.lifecycle.*
import com.example.materialstudy.data.BottomNavRepository
import com.example.materialstudy.data.MaterialRepository
import timber.log.Timber

class BottomNavViewModel internal constructor(
    private val repository: BottomNavRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val _firstFragmentCount = MutableLiveData<Int>()
    val firstFragmentCount: LiveData<Int>
        get() = _firstFragmentCount

    init {
        _firstFragmentCount.postValue(0)
    }

    fun countFirstFragment() {
//        firstFragmentC
//        repository.setFirstFragmentCount()

        Timber.tag("badgeTest").d("tick tick")

        _firstFragmentCount.value?.let { previousValue ->
            Timber.tag("badgeTest").d("prev Value : $previousValue")

            _firstFragmentCount.postValue(previousValue + 1)
//            firstFragmentCount.value = _firstFragmentCount
        }
    }

    fun countSecondFragment() {

    }

    fun countThirdFragment() {

    }

    private fun getSavedFavorite(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(FAVORITE_SAVED_STATE_KEY, NO_FAVORITE)
    }

    companion object {
        private const val NO_FAVORITE = -1
        private const val FAVORITE_SAVED_STATE_KEY = "FAVORITE_SAVED_STATE_KEY"
    }
}