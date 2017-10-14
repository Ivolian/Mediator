package com.unicorn.mediator.app.inject.module

import android.content.Context
import com.google.gson.Gson
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
    fun gson(): Gson = Gson()

    @Singleton
    @Provides
    fun newsRepository(context: Context, gson: Gson): NewsRepository = NewsRepositoryImpl(context, gson)

    @Singleton
    @Provides
    fun nediatorRepository(context: Context, gson: Gson): MediatorRepository = MediatorRepositoryImpl(context, gson)

    @Singleton
    @Provides
    fun homeRepository(newsRepo: NewsRepository, mediatorRepo: MediatorRepository):
            HomeRepository = HomeRepositoryImpl(newsRepo, mediatorRepo)

}