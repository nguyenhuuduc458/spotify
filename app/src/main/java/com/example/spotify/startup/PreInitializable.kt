package com.example.spotify.startup

import android.content.Context

interface PreInitializable {
    fun preInit(context: Context)
}
