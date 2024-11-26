package com.example.mylibrary

import androidx.annotation.Keep

@Keep
interface Configuration2 {
    val someString: String
    val someBool: Boolean
    @Keep
    companion object {
        @Keep
        operator fun invoke() : Configuration2 = object : Configuration2 {
            override val someString: String
                get() = "Configuration2.invoke()"
            override val someBool: Boolean
                get() = true

        }
    }
}