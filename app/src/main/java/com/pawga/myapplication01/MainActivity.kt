package com.pawga.myapplication01

import android.os.Bundle
import com.pawga.myapplication01.presentation.main.MainFragment

class MainActivity : BaseActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
