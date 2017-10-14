package com.unicorn.mediator.app.inject

import com.unicorn.mediator.app.App
import com.unicorn.mediator.app.inject.component.DaggerAppComponent
import com.unicorn.mediator.app.inject.module.AppModule


object ComponentsHolder {

    private lateinit var app: App

    fun init(app: App) {
        ComponentsHolder.app = app
    }

     val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
    }

}