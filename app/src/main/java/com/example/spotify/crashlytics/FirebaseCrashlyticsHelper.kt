package com.example.spotify.crashlytics

import android.content.Context
import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

class FirebaseCrashlyticsHelper
    @Inject
    constructor(
        private val crashlytics: FirebaseCrashlytics
    ): CrashlyticsHelper {
    override fun init(context: Context) = Unit

    override fun preInit(context: Context) = Unit

    override fun setEnable(enable: Boolean) {
        crashlytics.isCrashlyticsCollectionEnabled = enable
    }

    override fun recordException(exception: Throwable) = crashlytics.recordException(exception)

    override fun log(message: String)  = crashlytics.log(message)
}