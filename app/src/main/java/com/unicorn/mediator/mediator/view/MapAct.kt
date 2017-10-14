package com.unicorn.mediator.mediator.view

import com.unicorn.mediator.R
import kotlinx.android.synthetic.main.act_map.*


class MapAct:BaseMapAct(){

    override val layoutResId = R.layout.act_map

    val map by lazy { mapView.map }

}