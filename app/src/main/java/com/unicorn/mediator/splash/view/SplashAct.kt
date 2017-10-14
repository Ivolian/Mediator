package com.unicorn.mediator.splash.view

import com.bumptech.glide.Glide
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.splash.presenter.SplashPresenter
import kotlinx.android.synthetic.main.act_splash.*


class SplashAct : BaseAct(), SplashView {


    //  =============== Act ===============

    override val layoutResId = R.layout.act_splash


    //  =============== Presenter ===============

    private val presenter by lazy { SplashPresenter(this) }

    override fun bindPresenter() {
        presenter.onViewCreated()
    }


    //  =============== View ===============

    override fun renderBg() {
        Glide.with(this).load(R.mipmap.splash_bg).into(splashBg)
    }

}
