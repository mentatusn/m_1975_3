package com.gb.m_1975_3

import android.app.Application
import com.google.android.material.color.DynamicColors

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (DynamicColors.isDynamicColorAvailable()) {
            DynamicColors.applyToActivitiesIfAvailable(this)
        }
    }
}