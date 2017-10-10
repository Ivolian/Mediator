package com.unicorn.mediator.splash.presenter

import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.main.MainAct
import com.unicorn.mediator.splash.view.SplashView
import com.unicorn.mediator.startAct
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class SplashPresenterImpl(private val view: SplashView) : SplashPresenter {

    override fun onViewCreated() {
        view.renderSplashBg()
        startMainAct()
    }

    private fun startMainAct() {
        with(view as BaseAct) {
            Observable.just("")
                    .delay(2, TimeUnit.SECONDS)
                    .subscribe {
                        startAct(MainAct::class.java)
                        finish()
                    }
        }
    }

}