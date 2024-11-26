package com.example.mylibrary

import androidx.annotation.Keep

@Keep
interface Configuration {
    val someString: String
    val someBool: Boolean

    @Keep
    companion object {
        @JvmName("getDefault")
        @JvmStatic
        @Keep
        operator fun invoke() : Configuration = object : Configuration {
            override val someString: String
                get() = "Configuration.getDefault()"
            override val someBool: Boolean
                get() = false
        }
    }
}