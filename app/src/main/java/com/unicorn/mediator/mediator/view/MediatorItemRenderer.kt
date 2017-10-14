package com.unicorn.mediator.mediator.view

import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.Converter
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.mediator.model.entity.Mediator
import kotlinx.android.synthetic.main.item_mediator.*

/**
 * Created by ivotai on 2017/10/10/010.
 */
class MediatorItemRenderer(private val context: Context) : Converter<Mediator> {

    override fun convert(bvh: BVH, mediator: Mediator) {
        with(bvh) {
            tvName.text = mediator.name
            val list = mediator.biaoqian_replace.split(",")
            tvBiaoQian1.text = list[0]
            tvBiaoQian2.text = list[1]
            tvBiaoQian3.text = list[2]
            mediator.attr.touxiang[0].let {
                Glide.with(context).load(it.attached).into(ivTouXiang)
            }
            addOnClickListener(R.id.tvApplyMediation)
        }
    }

}