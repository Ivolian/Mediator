package com.unicorn.mediator.news.view.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.news.model.entity.News
import kotlinx.android.synthetic.main.item_news.*

/**
 * Created by ivotai on 2017/10/10/010.
 */
class NewsAdapter : BaseQuickAdapter<News, BVH>(R.layout.item_news) {

    override fun convert(bvh: BVH, news: News) {
        bvh.tvName.text = news.name
        bvh.tvTime.text = news.createtime_replace

        news.suoluetu[0].let {
            Glide.with(mContext).load(it.attached).into(bvh.imageView)
        }
    }

}