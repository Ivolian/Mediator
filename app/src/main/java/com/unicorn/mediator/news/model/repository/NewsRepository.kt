package com.unicorn.mediator.news.model.repository

import com.unicorn.mediator.news.model.entity.News


/**
* Created by ivotai on 2017/10/9/009.
*/
interface NewsRepository {

    fun get(): List<News>

}