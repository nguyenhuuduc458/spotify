package com.example.spotify.startup

import android.content.Context
import androidx.startup.Initializer
import com.example.spotify.crashlytics.CrashlyticsHelper
import com.example.spotify.dagger.InitializerEntryPoint
import javax.inject.Inject

class PreInitializer : Initializer<Unit> {
    @Inject
    lateinit var crashlyticsHelper: CrashlyticsHelper

    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context).inject(this)
        crashlyticsHelper.preInit(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> =
        listOf(
            DependencyGraphInitializer::class.java,
        )
}
