package com.unicorn.mediator.home.presenter

import com.unicorn.mediator.mediator.model.entity.Mediator

/**
 * Created by ivotai on 2017/10/10/010.
 */
interface HomePresenter {

    fun onViewCreated()

    fun onApplyMediation(mediator: Mediator)

}