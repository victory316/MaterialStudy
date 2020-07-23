package com.example.materialstudy

import com.example.materialstudy.di.DaggerMyComponent
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testDagger() {
        println(DaggerMyComponent.create().getString())
    }
}
