package com.unicorn.mediator.home.presenter

import com.blankj.utilcode.util.ToastUtils
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.view.HomeView
import com.unicorn.mediator.mediator.model.entity.Mediator


class HomePresenterImpl(private val view: HomeView, private val repository: HomeRepository) : HomePresenter {

    override fun onViewCreated() {
        view.render(repository.get())
    }

    override fun applyForMediation(mediator: Mediator) {
        ToastUtils.showShort(mediator.name)
    }

}

