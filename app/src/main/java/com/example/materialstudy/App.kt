package com.example.materialstudy

import android.app.Application
import android.os.Build
import timber.log.Timber

class App : Application() {

    override fun onCreate() {

        if (BuildConfig.DEBUG) {

            Timber.plant(Timber.DebugTree())
        }

        super.onCreate()
    }
}