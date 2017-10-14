package com.unicorn.mediator.mediator.view

import android.graphics.BitmapFactory
import android.view.View
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.MyLocationStyle
import com.bumptech.glide.Glide
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
            moveCamera(CameraUpdateFactory.zoomTo(14f))
            uiSettings.isMyLocationButtonEnabled = true
            // 开始定位
            isMyLocationEnabled = true
        }
    }

    override fun renderMarkers(mediators: List<Mediator>) {
        mediators.forEachIndexed { index, mediator ->
            map.addMarker(MarkerOptions().apply {
                title(index.toString())
                position(mediator.latLng)
                icon(BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(resources, R.mipmap.position_mediater)))
            })
        }
    }

    override fun renderMediator(mediator: Mediator) {
        Glide.with(this).load(mediator.attr.touxiang[0].attached).into(ivTouXiang)
        tvName.text = mediator.name
        val list = mediator.biaoqian_replace.split(",")
        tvTag1.text = list[0]
        tvTag2.text = list[1]
        tvTag3.text = list[2]
        clMediatorInfo.visibility = View.VISIBLE
    }

    private val presenter = MediatorMapPresenter(this,
            ComponentsHolder.appComponent.getMediatorRepository())

    override fun bindPresenter() {
        map.apply {
            setOnMyLocationChangeListener { location ->
                presenter.showMediatorsOnMap(location)
                setOnMyLocationChangeListener { }
            }
            setOnMarkerClickListener { marker -> presenter.onMarkerClick(marker) }
            setOnMapTouchListener { clMediatorInfo.visibility = View.INVISIBLE }
        }
        presenter.onViewCreated()
    }

}