package com.example.materialstudy.data

import androidx.lifecycle.LiveData
import com.example.materialstudy.data.local.MainDao

// TODO 추후 업데이트
class BottomNavRepository private constructor(private val dao: MainDao) {

    // Fragment들의 count들을 적용하기 이전 지역변수로 우선 테스트
    var firstFragmentCount = 0
    var secondFragmentCount = 0
    var thirdFragmentCount = 0

    fun setFragmentCount(input: CountData) {
        dao.insertData(input)
    }

    fun getCountData(): LiveData<List<CountData>> {
        return dao.getAll()
    }

    fun setFirstFragmentCount() {
        firstFragmentCount++
    }

    fun getCountOnFirstFragment(): Int {
        return firstFragmentCount
    }

    companion object {
        @Volatile
        private var instance: BottomNavRepository? = null

        fun getInstance(dao: MainDao) =
            instance ?: synchronized(this) {
                instance ?: BottomNavRepository(dao)
                    .also { instance = it }
            }
    }
}
