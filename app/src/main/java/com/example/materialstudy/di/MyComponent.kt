package com.example.materialstudy.di

import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {

    // 프로비전 메소드 : 바인드 된 모듈로부터 의존성을 제공받음.
    fun getString(): String
}