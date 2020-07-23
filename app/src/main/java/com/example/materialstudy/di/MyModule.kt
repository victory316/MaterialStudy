package com.example.materialstudy.di

import dagger.Module
import dagger.Provides

@Module
class MyModule {

    @Provides
    fun provideHelloWorld(): String {
        return "Hello world"
    }
}