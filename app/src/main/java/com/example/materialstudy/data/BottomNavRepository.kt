package com.example.materialstudy.data

import com.example.materialstudy.data.local.MainDao

// TODO 추후 업데이트
class BottomNavRepository private constructor(private val dao: MainDao) {

    companion object {
        @Volatile
        private var instance: BottomNavRepository? = null

        fun getInstance(dao: MainDao) =
            instance ?: synchronized(this) {
                instance?: BottomNavRepository(dao)
                    .also { instance = it }
            }
    }
}
