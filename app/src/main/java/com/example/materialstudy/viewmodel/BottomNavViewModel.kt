package com.example.materialstudy.viewmodel

import androidx.lifecycle.*
import com.example.materialstudy.data.BottomNavRepository
import com.example.materialstudy.data.MaterialRepository
import timber.log.Timber

class BottomNavViewModel internal constructor(
    private val repository: BottomNavRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // 각 프래그먼트들의 카운트를 Observing하는 LiveData
    val _firstFragmentCount = MutableLiveData<Int>()
    val firstFragmentCount: LiveData<Int>
        get() = _firstFragmentCount

    val _secondFragmentCount = MutableLiveData<Int>()
    val secondFragmentCount: LiveData<Int>
        get() = _secondFragmentCount

    val _thirdFragmentCount = MutableLiveData<Int>()
    val thirdFragmentCount: LiveData<Int>
        get() = _thirdFragmentCount


    init {
        _firstFragmentCount.postValue(0)
    }

    fun countFirstFragment() {
        _firstFragmentCount.value?.let { previousValue ->
            _firstFragmentCount.postValue(previousValue + 1)
        }
    }

    fun countSecondFragment() {
        _secondFragmentCount.value?.let { previousValue ->
            _secondFragmentCount.postValue(previousValue + 1)
        }
    }

    fun countThirdFragment() {
        _thirdFragmentCount.value?.let { previousValue ->
            _thirdFragmentCount.postValue(previousValue + 1)
        }
    }

    private fun getSavedFavorite(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(FAVORITE_SAVED_STATE_KEY, NO_FAVORITE)
    }

    companion object {
        private const val NO_FAVORITE = -1
        private const val FAVORITE_SAVED_STATE_KEY = "FAVORITE_SAVED_STATE_KEY"
    }
}