package com.unicorn.mediator.splash.presenter

import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.main.MainAct
import com.unicorn.mediator.splash.view.SplashView
import com.unicorn.mediator.startActAndFinish
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class SplashPresenter(private val view: SplashView) : BasePresenter {

    override fun onViewCreated() {
        view.renderSplashBg()
        toMain()
    }

    private fun toMain() {
        Observable.just("delay")
                .delay(2, TimeUnit.SECONDS)
                .subscribe { (view as? BaseAct)?.startActAndFinish(MainAct::class.java) }
    }

}