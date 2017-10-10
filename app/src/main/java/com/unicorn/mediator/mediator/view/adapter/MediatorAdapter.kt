package com.unicorn.mediator.mediator.view.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.mediator.model.entity.Mediator
import kotlinx.android.synthetic.main.item_mediator.*


/**
 * Created by ivotai on 2017/10/10/010.
 */
class MediatorAdapter : BaseQuickAdapter<Mediator, BVH>(R.layout.item_mediator) {

    @SuppressLint("SetTextI18n")
    override fun convert(bvh: BVH, mediator: Mediator) {
        bvh.tvName.text = mediator.name
        val list = mediator.biaoqian_replace.split(",")
        bvh.tvBiaoQian1.text = list[0]
        bvh.tvBiaoQian2.text = list[1]
        bvh.tvBiaoQian3.text = list[2]
        mediator.attr.touxiang[0].let {
            Glide.with(mContext).load(it.attached).into(bvh.ivTouXiang)
        }

        bvh.addOnClickListener(R.id.tvApplyMediation)
    }

}