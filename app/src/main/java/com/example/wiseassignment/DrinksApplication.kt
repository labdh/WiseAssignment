package com.example.wiseassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class DrinksApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}