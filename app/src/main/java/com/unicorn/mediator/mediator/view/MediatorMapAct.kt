package com.unicorn.mediator.mediator.view

import android.graphics.BitmapFactory
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.MyLocationStyle
import com.unicorn.mediator.R
import com.unicorn.mediator.app.inject.ComponentsHolder
import com.unicorn.mediator.app.view.BaseMapAct
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.presenter.MediatorMapPresenter
import kotlinx.android.synthetic.main.act_mediator_map.*


class MediatorMapAct : BaseMapAct(), MediatorMapView {

    override val layoutResId = R.layout.act_mediator_map

    private val map by lazy { mapView.map }

    override fun renderMap() {
        map.apply {
            myLocationStyle = MyLocationStyle().apply {
                // 定位一次，且将视角移动到地图中心点。
                myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)
                myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.poi2))
            }
            uiSettings.isMyLocationButtonEnabled = true
            // 开始定位
            isMyLocationEnabled = true
        }
    }

    override fun renderMediatorMarker(mediators: List<Mediator>) {
        mediators.forEach {
            val markerOption = MarkerOptions()
            markerOption.position(it.latLng)
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                    .decodeResource(resources, R.mipmap.position_mediater)))
            map.addMarker(markerOption)
        }
    }

    private val presenter = MediatorMapPresenter(this, ComponentsHolder.appComponent.getMediatorRepository())

    override fun bindPresenter() {
        map.apply {
            setOnMyLocationChangeListener { location ->
                presenter.showMediatorsOnMap(location)
                setOnMyLocationChangeListener {  }
            }
        }
        presenter.onViewCreated()
    }

}