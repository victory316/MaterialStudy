package com.example.materialstudy.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.freewheelinhw.data.BasicData
import com.example.materialstudy.data.CountData

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: CountData)

    @Query("DELETE FROM count_data")
    fun deleteAll()

    @Query("SELECT * FROM count_data")
    fun getAll(): LiveData<List<CountData>>
}