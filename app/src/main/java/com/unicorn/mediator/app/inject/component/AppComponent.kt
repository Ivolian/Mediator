package com.unicorn.mediator.app.inject.component

import com.unicorn.mediator.app.inject.module.AppModule
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.mediation.model.repository.MediationRepository
import com.unicorn.mediator.mediator.repository.MediatorRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun getHomeRepository(): HomeRepository
    fun getMediatorRepository(): MediatorRepository
    fun getMediationRepository(): MediationRepository

}