package com.unicorn.mediator.splash.presenter

import android.Manifest
import com.afollestad.materialdialogs.MaterialDialog
import com.blankj.utilcode.util.ToastUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.unicorn.mediator.UserInfo
import com.unicorn.mediator.app.presenter.BasePresenter
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.main.view.MainAct
import com.unicorn.mediator.splash.view.SplashView
import com.unicorn.mediator.startActAndFinish
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class SplashPresenter(private val view: SplashView) : BasePresenter {

    override fun onViewCreated() {
        view.renderBg()
        requestPermission()
    }

    private fun requestPermission() {
        (view as BaseAct).apply {
            RxPermissions(this)
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.ACCESS_COARSE_LOCATION)
                    .subscribe { granted ->
                        if (granted) {
                            showRoleDialog()
                        } else {
                            ToastUtils.showShort("未授予权限")
                            finish()
                        }
                    }
        }
    }

    private fun showRoleDialog(){
        MaterialDialog.Builder( view as BaseAct)
                .title("选择用户角色")
                .items(listOf("申请人","受理人"))
                .itemsCallback({dialog, itemView, position, text -> UserInfo.role = text.toString()
                    Observable.just("delay")
                            .delay(1, TimeUnit.SECONDS)
                            .subscribe {  (view as BaseAct).startActAndFinish(MainAct::class.java) }
                })
                .show()
    }

}

