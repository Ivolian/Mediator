package com.unicorn.mediator.home.view.converter

import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.app.view.Converter
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.entity.Title
import kotlinx.android.synthetic.main.item_title.*


class TitleConverter(private val context: Context) : Converter<Title> {

    override fun convert(bvh: BVH, entity: Title) {
        bvh.apply {
            Glide.with(context).load(entity.resId).into(imageView)
            tvTitle.text = entity.title
        }
    }

}