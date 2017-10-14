package com.unicorn.mediator.home.view.converter

import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.Glide
import com.unicorn.mediator.app.view.Converter
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.news.model.entity.News
import kotlinx.android.synthetic.main.item_news.*


class NewsConverter(private val context: Context) : Converter<News> {

    @SuppressLint("SetTextI18n")
    override fun convert(bvh: BVH, entity: News) {
        bvh.apply {
            Glide.with(context).load(entity.suoluetu[0].attached).into(ivSuoLueTu)
            tvName.text = entity.name
            tvLiuLanLiang.text = "浏览${entity.liulanliang}次"
            tvCreateTime.text = entity.createtime_replace
        }
    }

}