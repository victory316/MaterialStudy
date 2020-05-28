package com.example.materialstudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.materialstudy.data.MaterialRepository
import timber.log.Timber

class BottomNavViewModel internal constructor(
    private val repository: MaterialRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}