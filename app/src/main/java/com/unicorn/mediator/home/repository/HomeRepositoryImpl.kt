package com.unicorn.mediator.home.repository

import com.unicorn.mediator.R
import com.unicorn.mediator.home.model.entity.Title
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.news.model.repository.NewsRepository


class HomeRepositoryImpl(private val newsRepo: NewsRepository, private val mediatorRepo: MediatorRepository) : HomeRepository {

    override fun get() = ArrayList<Any>().apply {
        add(Title("资讯", R.mipmap.kuaixun))
        addAll(newsRepo.get())
        add(Title("优秀调解员", R.mipmap.mediater2))
        addAll(mediatorRepo.get())
    }

}