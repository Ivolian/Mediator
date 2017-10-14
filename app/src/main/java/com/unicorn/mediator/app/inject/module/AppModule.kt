package com.unicorn.mediator.app.inject.module

import android.content.Context
import com.unicorn.mediator.app.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @Provides
    fun context(): Context = app.applicationContext

}