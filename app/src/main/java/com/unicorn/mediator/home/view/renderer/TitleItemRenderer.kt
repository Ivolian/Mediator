package com.unicorn.mediator.home.view.renderer

import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.app.view.BaseItemRenderer
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.entity.Title
import kotlinx.android.synthetic.main.item_title.*


/**
 * Created by ivotai on 2017/10/10/010.
 */
class TitleItemRenderer(private val context: Context) : BaseItemRenderer<Title> {

    override fun render(bvh: BVH, title: Title) {
        with(bvh) {
            tvTitle.text = title.title
            Glide.with(context).load(title.resId).into(imageView)
        }
    }

}