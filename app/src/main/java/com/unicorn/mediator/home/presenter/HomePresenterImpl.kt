package com.unicorn.mediator.home.presenter

import com.blankj.utilcode.util.ToastUtils
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.mediator.view.MediatorView
import com.unicorn.mediator.news.model.repository.NewsRepository
import com.unicorn.mediator.news.view.NewsView

/**
 * Created by ivotai on 2017/10/10/010.
 */

class HomePresenterImpl(
        private val newsView: NewsView,
        private val newsRepository: NewsRepository,
        private val mediatorView: MediatorView,
        private val mediatorRepository: MediatorRepository
) : HomePresenter {

    override fun onViewCreated() {
        newsView.renderNewsList(newsRepository.get())
        mediatorView.renderMediators(mediatorRepository.get())
    }

    override fun onApplyMediation(mediator: Mediator) {
        ToastUtils.showShort(mediator.name)
    }

}

