package com.example.thitnuong

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dinhtc.android.thitnuong.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}