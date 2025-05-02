package com.example.spotify.crashlytics

import android.content.Context
import com.example.spotify.startup.PreInitializable

interface CrashlyticsHelper: PreInitializable {
    fun init(context: Context)

    fun setEnable(enable: Boolean)

    fun recordException(exception: Throwable)

    fun log(message: String)
}