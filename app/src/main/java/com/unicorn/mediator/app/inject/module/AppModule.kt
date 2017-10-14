package com.unicorn.mediator.app.inject.module

import android.content.Context
import com.unicorn.mediator.app.App
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.repository.HomeRepositoryImpl
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.mediator.repository.MediatorRepositoryImpl
import com.unicorn.mediator.news.model.repository.NewsRepository
import com.unicorn.mediator.news.model.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun context(): Context = app.applicationContext

    @Singleton
    @Provides
    fun NewsRepository(context: Context): NewsRepository = NewsRepositoryImpl(context)

    @Singleton
    @Provides
    fun MediatorRepository(context: Context): MediatorRepository = MediatorRepositoryImpl(context)

    @Singleton
    @Provides
    fun HomeRepository(newsRepository: NewsRepository, mediatorRepository: MediatorRepository):HomeRepository
            = HomeRepositoryImpl(newsRepository, mediatorRepository)

}