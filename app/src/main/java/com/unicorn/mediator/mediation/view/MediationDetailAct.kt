package com.unicorn.mediator.mediation.view

import activitystarter.Arg
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.jakewharton.rxbinding2.view.RxView
import com.marcinmoskala.activitystarter.argExtra
import com.unicorn.mediator.R
import com.unicorn.mediator.UserInfo
import com.unicorn.mediator.app.inject.ComponentsHolder
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.mediation.model.constant.MediationStatus
import com.unicorn.mediator.mediation.model.entity.Mediation
import kotlinx.android.synthetic.main.act_mediation_detail.*
import java.util.concurrent.TimeUnit


class MediationDetailAct : BaseAct() {

    @get:Arg(parceler = true)
    val mediation: Mediation by argExtra()

    override val layoutResId = R.layout.act_mediation_detail

    private val repo = ComponentsHolder.appComponent.getMediationRepository()

    override fun initView(savedInstanceState: Bundle?) {
        tvAcceptor.text = mediation.acceptor
        tvApplicant.text = mediation.applicant
        tvRespondent.text = mediation.respondent
        tvCaseType.text = mediation.caseType
        tvCaseTitle.text = mediation.caseTitle
        tvCaseAddress.text = mediation.caseAddress
        tvDocumentType.text = mediation.documentType
        tvDocumentNum.text = mediation.documentNum
        setOperation()
    }

    private fun setOperation() {
        if (mediation.mediationStatusName == MediationStatus.Cancel.name) {
            tvOperation1.visibility = View.GONE
            tvOperation2.visibility = View.GONE
        }
        if (mediation.mediationStatusName == MediationStatus.Complete.name) {
            tvOperation1.visibility = View.GONE
            tvOperation2.visibility = View.GONE
        }
        if (mediation.mediationStatusName == MediationStatus.Mediating.name) {
            if (UserInfo.role == "申请人") {
                tvOperation1.text = "调解完成"
                RxView.clicks(tvOperation1).throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe {
                            mediation.mediationStatusName = MediationStatus.Complete.name
                            repo.put(mediation)
                            ToastUtils.showShort("已确认调解完成")
                            finish()
                        }
                tvOperation2.text = "调解失败"
                RxView.clicks(tvOperation2).throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe {
                            mediation.mediationStatusName = MediationStatus.Complete.name
                            repo.put(mediation)
                            ToastUtils.showShort("已确认调解失败")
                            finish()
                        }
            } else {
                tvOperation1.visibility = View.GONE
                tvOperation2.visibility = View.GONE
            }
        }

        if (mediation.mediationStatusName == MediationStatus.Checking.name) {
            if (UserInfo.role == "申请人") {
                tvOperation1.text = "取消申请"
                RxView.clicks(tvOperation1).throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe {
                            mediation.mediationStatusName = MediationStatus.Cancel.name
                            repo.put(mediation)
                            ToastUtils.showShort("已取消调解申请")
                            finish()
                        }
                tvOperation2.visibility = View.GONE
            } else {
                tvOperation2.text = "拒绝申请"
                RxView.clicks(tvOperation2).throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe {
                            mediation.mediationStatusName = MediationStatus.Cancel.name
                            repo.put(mediation)
                            ToastUtils.showShort("已拒绝调解申请")
                            finish()
                        }
                tvOperation1.text = "接受申请"
                RxView.clicks(tvOperation1).throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe {
                            mediation.mediationStatusName = MediationStatus.Mediating.name
                            repo.put(mediation)
                            ToastUtils.showShort("已接受调解申请")
                            finish()
                        }
            }
        }

    }


}