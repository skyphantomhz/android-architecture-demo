package com.example.demolocol

import android.app.Application
import com.example.data.di.dataModule
import com.example.demolocol.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(viewModelModule + dataModule)
        }
    }
}