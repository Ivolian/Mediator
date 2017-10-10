package com.unicorn.mediator.home.repository

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.news.model.repository.NewsRepository

/**
 * Created by ivotai on 2017/10/10/010.
 */
class HomeRepositoryImpl(private val newsRepository: NewsRepository, private val mediatorRepository: MediatorRepository) : HomeRepository {

    override fun get(): List<MultiItemEntity> {

        var list = ArrayList<MultiItemEntity>()

        var newsList = newsRepository.get()
        list.addAll(newsList)

        var mediators = mediatorRepository.get()
        list.addAll(mediators)
        return list;
    }

}