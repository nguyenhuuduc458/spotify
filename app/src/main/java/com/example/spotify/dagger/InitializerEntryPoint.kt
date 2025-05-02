package com.example.spotify.dagger

import android.content.Context
import com.example.spotify.startup.CrashlyticsInitializer
import com.example.spotify.startup.LoggerInitializer
import com.example.spotify.startup.PreInitializer
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface InitializerEntryPoint {
    fun inject(crashlyticsInitializer: CrashlyticsInitializer)

    fun inject(loggerInitializer: LoggerInitializer)

    fun inject(preInitializer: PreInitializer)

    companion object {
        fun resolve(context: Context): InitializerEntryPoint {
            val appContext =
                context.applicationContext ?: throw IllegalStateException(
                    "Context is not an application context",
                )
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java,
            )
        }
    }
}
