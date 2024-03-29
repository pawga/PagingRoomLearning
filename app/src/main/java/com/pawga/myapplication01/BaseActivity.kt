package com.pawga.myapplication01

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import toothpick.Scope
import toothpick.ktp.KTP
import toothpick.smoothie.lifecycle.closeOnDestroy

/**
 * Created by pawga on 29.12.19 17:14
 */

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getScope().supportScopeAnnotation(ActivityScope::class.java)
            .installModules(ActivityModule(this))
            .closeOnDestroy(this)
            .inject(this)
    }

    open fun getScope(): Scope {
        return KTP.openRootScope()
            .openSubScope(ApplicationScope::class.java)
            .openSubScope(this)
    }
}