package com.unicorn.mediator.home.presenter

import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.mediator.model.entity.Mediator


interface HomePresenter : BasePresenter {

    fun applyForMediation(mediator: Mediator)

}