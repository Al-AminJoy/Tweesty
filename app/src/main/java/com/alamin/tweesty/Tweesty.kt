package com.alamin.tweesty

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Tweesty : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}