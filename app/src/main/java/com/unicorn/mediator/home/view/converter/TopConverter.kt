package com.unicorn.mediator.home.view.converter

import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.Converter
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.entity.Top
import kotlinx.android.synthetic.main.item_top.*


class TopConverter(private val context: Context) : Converter<Top> {

    override fun convert(bvh: BVH, entity: Top) {
        bvh.apply {
            Glide.with(context).load(entity.resId).into(imageView)
            tvText.text = entity.text
            addOnClickListener(R.id.tvText)
        }
    }

}