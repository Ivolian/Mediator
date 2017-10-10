package com.unicorn.mediator.news.view

import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.app.view.BaseItemRenderer
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.news.model.entity.News
import kotlinx.android.synthetic.main.item_news.*


/**
 * Created by ivotai on 2017/10/10/010.
 */
class NewsItemRenderer(private val context: Context) : BaseItemRenderer<News> {

    @SuppressLint("SetTextI18n")
    override fun render(bvh: BVH, entity: News) {
        with(bvh) {
            tvName.text = entity.name
            tvBiaoQian1.text = "浏览${entity.liulanliang}次"
            tvCreateTime.text = entity.createtime_replace
            entity.suoluetu[0].let {
                Glide.with(context).load(it.attached).into(ivSuoLueTu)
            }
        }

    }

}