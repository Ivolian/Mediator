package com.unicorn.mediator.mediation.view

import android.os.Bundle
import com.unicorn.mediator.R
import com.unicorn.mediator.UserInfo
import com.unicorn.mediator.app.view.BaseFra
import kotlinx.android.synthetic.main.fra_meidation.*


class MediationFra : BaseFra() {

    override val layoutResId = R.layout.fra_meidation

    override fun initView(savedInstanceState: Bundle?) {
        tvTitle.text = UserInfo.role
    }

}