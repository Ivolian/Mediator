package com.unicorn.mediator.home.view.converter

import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.Converter
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.mediator.model.entity.Mediator
import kotlinx.android.synthetic.main.item_mediator.*


class MediatorConverter(private val context: Context) : Converter<Mediator> {

    override fun convert(bvh: BVH, entity: Mediator) {
        bvh.apply {
            Glide.with(context).load( entity.attr.touxiang[0].attached).into(ivTouXiang)
            tvName.text = entity.name
            val list = entity.biaoqian_replace.split(",")
            tvTag1.text = list[0]
            tvTag2.text = list[1]
            tvTag3.text = list[2]
            addOnClickListener(R.id.tvApplyForMediation)
        }
    }

}