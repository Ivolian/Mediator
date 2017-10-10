package com.unicorn.mediator.app

import android.app.Application
import com.blankj.utilcode.util.Utils
import net.danlew.android.joda.JodaTimeAndroid


class App:Application(){

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        JodaTimeAndroid.init(this)
    }

}