package com.unicorn.mediator.home.view.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.util.MultiTypeDelegate
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.entity.Title
import com.unicorn.mediator.home.model.entity.Top
import com.unicorn.mediator.home.view.converter.MediatorConverter
import com.unicorn.mediator.home.view.converter.NewsConverter
import com.unicorn.mediator.home.view.converter.TitleConverter
import com.unicorn.mediator.home.view.converter.TopConverter
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.news.model.entity.News


class HomeAdapter : BaseQuickAdapter<Any, BVH>(null) {

    init {
        object : MultiTypeDelegate<Any>() {
            override fun getItemType(entity: Any) = when (entity) {
                is Top -> HomeItemType.TOP.ordinal
                is Title -> HomeItemType.TITLE.ordinal
                is News -> HomeItemType.NEWS.ordinal
                is Mediator -> HomeItemType.MEDIATOR.ordinal
                else -> throw RuntimeException("")
            }
        }.apply {
            registerItemType(HomeItemType.TOP.ordinal, R.layout.item_top)
            registerItemType(HomeItemType.TITLE.ordinal, R.layout.item_title)
            registerItemType(HomeItemType.NEWS.ordinal, R.layout.item_news)
            registerItemType(HomeItemType.MEDIATOR.ordinal, R.layout.item_mediator)
        }.let { multiTypeDelegate = it }
    }

    override fun convert(bvh: BVH, entity: Any) {
        when (entity) {
            is Top -> TopConverter(mContext).convert(bvh, entity)
            is Title -> TitleConverter(mContext).convert(bvh, entity)
            is News -> NewsConverter(mContext).convert(bvh, entity)
            is Mediator -> MediatorConverter(mContext).convert(bvh, entity)
        }
    }
}

private enum class HomeItemType {
    TOP,
    TITLE,
    NEWS,
    MEDIATOR
}