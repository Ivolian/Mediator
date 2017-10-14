package com.unicorn.mediator.mediator.view

import com.unicorn.mediator.mediator.model.entity.Mediator


interface MediatorMapView {

    fun renderMap()

    fun renderMarkers(mediators: List<Mediator>)

    fun renderMediator(mediator:Mediator)

}