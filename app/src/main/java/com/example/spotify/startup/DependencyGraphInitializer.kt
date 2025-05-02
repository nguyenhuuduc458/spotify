package com.example.spotify.startup

import android.content.Context
import androidx.startup.Initializer
import com.example.spotify.dagger.InitializerEntryPoint

class DependencyGraphInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}