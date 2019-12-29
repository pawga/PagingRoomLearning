package com.pawga.myapplication01

import android.app.Application
import com.pawga.myapplication01.AppConsants.Companion.APPSCOPE
import toothpick.configuration.Configuration
import toothpick.ktp.KTP

/**
 * Created by pawga on 29.12.19 17:07
 */

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        initializeToothpick()
    }

    private fun initializeToothpick() {

        if (BuildConfig.DEBUG) {
            KTP.setConfiguration(Configuration.forDevelopment())
            KTP.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        }

        KTP.openRootScope()
            .openSubScope(APPSCOPE)
            .installModules(AppModule(this))
            .inject(this)
    }
}