package com.unicorn.mediator

import android.os.Bundle
import com.bumptech.glide.Glide
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.act_splash.*


class SplashAct : BaseAct() {

    override val layoutResId = R.layout.act_splash

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtil.setTransparent(this)
        Glide.with(this).load(R.mipmap.splash_bg).into(splashBg)
    }

    override fun injectDependencies() {
        // do nothing
    }

    override fun bindPresenter() {
        // do nothing
    }

}
