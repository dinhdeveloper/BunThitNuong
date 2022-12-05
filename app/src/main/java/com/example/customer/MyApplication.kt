package com.example.customer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dinhtc.android.customer.BuildConfig
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