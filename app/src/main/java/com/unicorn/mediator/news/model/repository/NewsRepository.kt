package com.unicorn.mediator.news.model.repository

import com.unicorn.mediator.news.model.entity.News


interface NewsRepository {

    fun get(): List<News>

}