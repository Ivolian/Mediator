package com.unicorn.mediator.mediation.view.adapter

import android.annotation.SuppressLint
import com.chad.library.adapter.base.BaseQuickAdapter
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.mediation.model.entity.Mediation
import kotlinx.android.synthetic.main.item_mediation.*


class MediationAdapter : BaseQuickAdapter<Mediation, BVH>(R.layout.item_mediation) {

    @SuppressLint("SetTextI18n")
    override fun convert(helper: BVH, item: Mediation) {
        helper.apply {
            tvCaseTitle.text = "标题:${item.caseTitle}"
            tvApplicant.text = "申请人:${item.applicant}"
            tvAcceptor.text = "受理人:${item.acceptor}"
        }
    }

}