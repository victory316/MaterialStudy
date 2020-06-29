package com.example.materialstudy

import android.app.Application
import dagger.Provides
import javax.inject.Singleton

class AppModule {

    private lateinit var mApplication: Application

    constructor(application: Application) {
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
}