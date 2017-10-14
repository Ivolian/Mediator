package com.unicorn.mediator.app.inject.component

import com.unicorn.mediator.app.inject.module.AppModule
import com.unicorn.mediator.home.view.adapter.HomeAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(o:HomeAdapter)

}