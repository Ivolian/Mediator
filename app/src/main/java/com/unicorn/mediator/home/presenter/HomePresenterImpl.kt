package com.unicorn.mediator.home.presenter

import com.blankj.utilcode.util.ToastUtils
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.view.HomeView
import com.unicorn.mediator.mediator.model.entity.Mediator

/**
 * Created by ivotai on 2017/10/10/010.
 */

class HomePresenterImpl(
        private val homeView: HomeView,
        private val homeRepository: HomeRepository
) : HomePresenter {

    override fun onViewCreated() {
        homeView.render(homeRepository.get())
    }

    override fun onApplyMediation(mediator: Mediator) {
        ToastUtils.showShort(mediator.name)
    }

}

