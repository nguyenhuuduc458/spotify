package com.example.spotify.startup

import android.content.Context
import androidx.startup.Initializer
import com.example.spotify.crashlytics.CrashlyticsHelper
import com.example.spotify.dagger.InitializerEntryPoint
import javax.inject.Inject

class LoggerInitializer : Initializer<Unit> {
    @Inject
    lateinit var crashlyticsHelper: CrashlyticsHelper

    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context).inject(this)
        // Config logback in future
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(CrashlyticsInitializer::class.java)

    companion object {
        private const val MAX_LOG_FILES: Int = 9
    }
}
