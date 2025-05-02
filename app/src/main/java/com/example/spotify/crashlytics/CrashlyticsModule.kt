package com.example.spotify.crashlytics

import com.google.firebase.Firebase
import com.google.firebase.crashlytics.crashlytics
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CrashlyticsModule {
    @Binds
    fun bindCrashlyticsHelper(impl: FirebaseCrashlyticsHelper): CrashlyticsHelper

    companion object {
        @Singleton
        @Provides
        fun provideFirebaseCrashlytics() = Firebase.crashlytics
    }
}
