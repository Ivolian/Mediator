package com.unicorn.mediator.news.view

import com.unicorn.mediator.news.model.entity.News

/**
 * Created by ivotai on 2017/10/9/009.
 */
interface NewsView {

    fun render(newsList: List<News>)

}