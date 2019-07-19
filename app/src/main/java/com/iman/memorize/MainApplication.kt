package com.iman.memorize

import android.app.Application
import com.iman.memorize.utils.network.NetworkChecker
import com.iman.memorize.utils.network.NetworkCheckerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }

    }
    val appModule = module {

        // single instance of HelloRepository
        single<NetworkChecker> { NetworkCheckerImpl() }

        // Simple Presenter Factory
       // factory { MySimplePresenter(get()) }
    }
}