package com.unicorn.mediator.home.presenter

import com.unicorn.mediator.news.model.repository.NewsRepository
import com.unicorn.mediator.news.view.NewsView

/**
 * Created by ivotai on 2017/10/10/010.
 */

class HomePresenterImpl(val newsView: NewsView,val newsRepository: NewsRepository):HomePresenter{

    override fun onViewCreated() {
        newsView.render(newsRepository.get())
    }

}

