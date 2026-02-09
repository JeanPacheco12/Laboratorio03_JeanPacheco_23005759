package com.example.streamui

import android.app.Application
import com.example.streamui.di
import com.example.streamui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StreamUIApp : Application {
    override fun onCreate() {
        super.onCreate()

        // Inicio de Koin
        startKoin {
            androidContext(this@StreamUIApp)
            modules(appModule)
        }
    }
}