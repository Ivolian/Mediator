package com.unicorn.mediator.app.view

import android.os.Bundle
import com.unicorn.mediator.app.view.BaseAct
import kotlinx.android.synthetic.main.act_mediator_map.*


abstract class BaseMapAct : BaseAct() {

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mapView.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

}