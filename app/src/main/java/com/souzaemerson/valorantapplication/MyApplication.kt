package com.souzaemerson.valorantapplication

import android.app.Application
import com.souzaemerson.valorantapplication.hawk.ModuleHawk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ModuleHawk.init(applicationContext)
    }
}