package com.example.spotify.startup

import android.content.Context
import androidx.startup.Initializer
import com.example.spotify.crashlytics.CrashlyticsHelper
import com.example.spotify.dagger.InitializerEntryPoint
import javax.inject.Inject

class CrashlyticsInitializer: Initializer<CrashlyticsHelper> {
    @Inject
    lateinit var crashlyticsHelper: CrashlyticsHelper

    override fun create(context: Context): CrashlyticsHelper {
        InitializerEntryPoint.resolve(context).inject(this)
        return crashlyticsHelper.apply {
            setEnable(true)
            init(context)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(
        PreInitializer::class.java
    )
}