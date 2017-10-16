package com.unicorn.mediator.other

import activitystarter.Arg
import android.os.Bundle
import com.marcinmoskala.activitystarter.argExtra
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseFra
import kotlinx.android.synthetic.main.fra_empty.*


class EmptyFra : BaseFra() {

    @get:Arg
    val title: String by argExtra()

    override val layoutResId = R.layout.fra_empty

    override fun initView(savedInstanceState: Bundle?) {
        tvTitle.text = title
    }

}