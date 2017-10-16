package com.unicorn.mediator.app.inject.module

import android.content.Context
import com.google.gson.Gson
import com.unicorn.mediator.BuildConfig
import com.unicorn.mediator.app.App
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.repository.HomeRepositoryImpl
import com.unicorn.mediator.mediation.model.entity.Mediation
import com.unicorn.mediator.mediation.model.entity.MyObjectBox
import com.unicorn.mediator.mediation.model.repository.MediationRepository
import com.unicorn.mediator.mediation.model.repository.MediationRepositoryImpl
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.mediator.repository.MediatorRepositoryImpl
import com.unicorn.mediator.news.model.repository.NewsRepository
import com.unicorn.mediator.news.model.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser
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
    fun mediatorRepository(context: Context, gson: Gson): MediatorRepository = MediatorRepositoryImpl(context, gson)

    @Singleton
    @Provides
    fun homeRepository(newsRepo: NewsRepository, mediatorRepo: MediatorRepository):
            HomeRepository = HomeRepositoryImpl(newsRepo, mediatorRepo)

    @Singleton
    @Provides
    fun boxStore(context: Context): BoxStore {
        val boxStore = MyObjectBox.builder().androidContext(context).build()
        if (BuildConfig.DEBUG) {
            AndroidObjectBrowser(boxStore).start(context)
        }
        return boxStore
    }

    @Singleton
    @Provides
    fun mediationBox(boxStore: BoxStore): Box<Mediation> = boxStore.boxFor(Mediation::class.java)

    @Singleton
    @Provides
    fun mediationRepository(box: Box<Mediation>): MediationRepository = MediationRepositoryImpl(box)

}