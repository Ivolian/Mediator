package com.unicorn.mediator.mediation.view

import android.os.Bundle
import com.jakewharton.rxbinding2.view.RxView
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.mediation.view.ui.BottomSheetListener
import com.unicorn.mediator.mediation.view.ui.BottomSheetStarter
import kotlinx.android.synthetic.main.act_apply_mediation.*
import java.util.concurrent.TimeUnit


class ApplyMediationAct : BaseAct() {

    override val layoutResId = R.layout.act_apply_mediation
    private val caseType = arrayListOf("领里纠纷", "损坏赔偿", "劳动争议", "医疗纠纷", "婚姻家庭", "环境污染")
    private val documentType = arrayListOf("身份证", "军官证", "护照", "港澳通行证")

    override fun initView(savedInstanceState: Bundle?) {

        RxView.clicks(tvCaseType).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe {
                    val bs = BottomSheetStarter.newInstance("选择案件类型", caseType)
                    bs.listener = object : BottomSheetListener {
                        override fun onConfirm(pos: Int) {
                            tvCaseType.text = caseType[pos]
                        }
                    }
                    bs.show(supportFragmentManager)
                }
        RxView.clicks(tvDocumentType).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe {
                    val bs = BottomSheetStarter.newInstance("选择证件类型", documentType)
                    bs.listener = object : BottomSheetListener {
                        override fun onConfirm(pos: Int) {
                            tvDocumentType.text = documentType[pos]
                        }
                    }
                    bs.show(supportFragmentManager)
                }
    }
}

