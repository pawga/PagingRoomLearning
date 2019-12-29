package com.pawga.myapplication01

import android.app.Application
import timber.log.Timber
import toothpick.configuration.Configuration
import toothpick.ktp.KTP

/**
 * Created by pawga on 29.12.19 17:07
 */

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        initializeTimber()
        initializeToothpick()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initializeToothpick() {

        if (BuildConfig.DEBUG) {
            KTP.setConfiguration(Configuration.forDevelopment())
            KTP.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        }

        KTP.openRootScope()
            .openSubScope(ApplicationScope::class.java)
            .installModules(AppModule(this))
            .inject(this)
    }
}