package com.example.materialstudy.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.materialstudy.data.MaterialRepository

class MaterialViewModel internal constructor(
    private val repository: MaterialRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}