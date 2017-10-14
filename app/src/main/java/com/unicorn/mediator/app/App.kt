package com.unicorn.mediator.app

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.unicorn.mediator.app.inject.ComponentsHolder
import net.danlew.android.joda.JodaTimeAndroid


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentsHolder.init(this)

        Utils.init(this)
        JodaTimeAndroid.init(this)
    }

}