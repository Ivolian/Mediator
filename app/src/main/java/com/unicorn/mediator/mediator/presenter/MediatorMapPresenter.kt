package com.unicorn.mediator.mediator.presenter

import android.location.Location
import com.amap.api.maps.model.Marker
import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.repository.MediatorRepository
import com.unicorn.mediator.mediator.view.MediatorMapView


class MediatorMapPresenter(private val view: MediatorMapView, private val repo: MediatorRepository) : BasePresenter {

    override fun onViewCreated() {
        view.renderMap()
    }

    lateinit var mediators: List<Mediator>

    fun showMediatorsOnMap(location: Location) {
        mediators = repo.get(location).apply { view.renderMarkers(this) }
    }

    fun onMarkerClick(marker: Marker): Boolean {
        val index = marker.title.toInt()
        view.renderMediator(mediators[index])
        return true
    }

}