package com.example.materialstudy.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_data")
data class CountData(

    @PrimaryKey
    @ColumnInfo(name = "page_index")
    val page_index: Int,

    @ColumnInfo(name = "count")
    val count: Int
)