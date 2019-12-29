package com.pawga.myapplication01

import android.app.Activity
import android.content.Context
import toothpick.config.Module

/**
 * Created by pawga on 29.12.19 17:15
 */

class ActivityModule(activity: Activity) : Module() {

    init {
        bind(Context::class.java).toInstance(activity)
    }
}