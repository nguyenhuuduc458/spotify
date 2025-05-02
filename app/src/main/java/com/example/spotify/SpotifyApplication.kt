package com.example.spotify

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotifyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}