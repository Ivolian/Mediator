package com.unicorn.mediator.mediator.view

import android.os.Bundle
import com.amap.api.maps.model.MyLocationStyle
import com.unicorn.mediator.R
import kotlinx.android.synthetic.main.act_map.*


class MediatorAct : BaseMapAct() {

    override val layoutResId = R.layout.act_map

    private val map by lazy { mapView.map }
    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        initMap()
    }

    private fun initMap() {
        MyLocationStyle().apply {
            // 定位一次，且将视角移动到地图中心点。
            myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)
        }.let { map.myLocationStyle = it }

        // 开始定位
        map.isMyLocationEnabled = true
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
//        aMap.setMyLocationEnabled(true)// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }


}