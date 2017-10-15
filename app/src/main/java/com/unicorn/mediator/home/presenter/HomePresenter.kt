package com.unicorn.mediator.home.presenter

import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.home.repository.HomeRepository
import com.unicorn.mediator.home.view.HomeFra
import com.unicorn.mediator.home.view.HomeView
import com.unicorn.mediator.mediation.view.ApplyMediationAct
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.view.MediatorMapAct
import com.unicorn.mediator.startAct


class HomePresenter(private val view: HomeView, private val repo: HomeRepository) : BasePresenter {

    override fun onViewCreated() {
        view.render(repo.get())
    }

    fun applyForMediation(mediator: Mediator) {
        mediator.latLng
        (view as HomeFra).startAct(ApplyMediationAct::class.java)
    }

    fun lookForMediator() {
        (view as HomeFra).startAct(MediatorMapAct::class.java)
    }

}

