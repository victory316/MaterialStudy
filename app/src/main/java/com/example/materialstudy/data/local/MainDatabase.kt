package com.example.materialstudy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.materialstudy.data.CountData

@Database(entities = [CountData::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract fun mainDao(): MainDao

    companion object {
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase? {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java, "github_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}