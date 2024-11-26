package com.example.mylibrary

import org.junit.Test

import org.junit.Assert.*

/**
 * Tests the invocation calls of [Configuration] and [Configuration2].
 */
class ExampleUnitTest {

    /**
     * This test fails because R8 removes the `operator fun invoke()` when using published artifact.
     */
    @Test
    fun configurationInvoke() {
        Configuration()
    }

    /**
     * The invoke call via JvmName functions as expected.
     */
    @Test
    fun configurationJavaProxy() {
        ConfigProxy.getDefault()
    }

    /**
     * The invoke call without JvmName annotation also works.
     */
    @Test
    fun configuration2WithoutJvmName() {
        Configuration2()
    }
}