package com.example.deeplapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DeeplApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}