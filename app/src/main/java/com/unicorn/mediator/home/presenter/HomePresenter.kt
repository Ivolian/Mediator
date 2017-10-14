package com.unicorn.mediator.home.presenter

import com.blankj.utilcode.util.ToastUtils
import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.view.HomeView
import com.unicorn.mediator.mediator.model.entity.Mediator


class HomePresenter(private val view: HomeView, private val repository: HomeRepository) : BasePresenter {

    override fun onViewCreated() {
        view.render(repository.get())
    }

     fun applyForMediation(mediator: Mediator) {
        ToastUtils.showShort(mediator.name)
    }

}

