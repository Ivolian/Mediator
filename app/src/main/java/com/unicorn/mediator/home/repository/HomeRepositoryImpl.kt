package com.unicorn.mediator.home.repository

import com.unicorn.mediator.R
import com.unicorn.mediator.home.model.entity.Title
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.news.model.repository.NewsRepository

/**
 * Created by ivotai on 2017/10/10/010.
 */
class HomeRepositoryImpl(private val newsRepository: NewsRepository, private val mediatorRepository: MediatorRepository) : HomeRepository {

    override fun get(): List<Any> {

        var list = ArrayList<Any>()

        var newsList = newsRepository.get()
       list.add(Title(R.mipmap.kuaixun,"资讯"))
        list.addAll(newsList)
        list.add(Title(R.mipmap.mediater2,"优秀调解员"))
        var mediators = mediatorRepository.get()
        list.addAll(mediators)
        return list
    }

}