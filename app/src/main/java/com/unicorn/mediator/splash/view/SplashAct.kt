package com.unicorn.mediator.splash.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.jaeger.library.StatusBarUtil
import com.unicorn.mediator.BaseAct
import com.unicorn.mediator.R
import com.unicorn.mediator.splash.presenter.SplashPresenter
import com.unicorn.mediator.splash.presenter.SplashPresenterImpl
import kotlinx.android.synthetic.main.act_splash.*


class SplashAct : BaseAct(), SplashView {

    override val layoutResId = R.layout.act_splash

    override fun injectDependencies() {
        // do nothing
    }

    override fun initView(savedInstanceState: Bundle?) {
        // do nothing
    }

    private val presenter: SplashPresenter = SplashPresenterImpl(this)

    override fun bindPresenter() {
        presenter.onViewCreated()
    }

    override fun hideStatusBar() {
        StatusBarUtil.setTransparent(this)
    }

    override fun renderSplashBg() {
        Glide.with(this).load(R.mipmap.splash_bg).into(splashBg)
    }

}
