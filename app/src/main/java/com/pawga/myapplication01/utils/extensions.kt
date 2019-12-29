package com.pawga.myapplication01.utils

import java.util.concurrent.Executors

/**
 * Created by pawga on 29.12.19 16:44
 */

/**
 * Utility method to run blocks on a dedicated background thread, may be used for io/database work.
 */
fun ioThread(f: () -> Unit) {
    Executors.newSingleThreadExecutor().execute(f)
}