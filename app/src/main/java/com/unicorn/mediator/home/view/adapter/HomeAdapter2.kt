package com.unicorn.mediator.home.view.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.util.MultiTypeDelegate
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.entity.Title
import com.unicorn.mediator.home.view.renderer.TitleItemRenderer
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.view.MediatorItemRenderer
import com.unicorn.mediator.news.model.entity.News
import com.unicorn.mediator.news.view.NewsItemRenderer


class HomeAdapter : BaseQuickAdapter<Any, BVH>(null) {

    init {
        object : MultiTypeDelegate<Any>() {
            override fun getItemType(entity: Any) = when (entity) {
                is Title -> HomeItemType.TITLE.ordinal
                is News -> HomeItemType.NEWS.ordinal
                is Mediator -> HomeItemType.MEDIATOR.ordinal
                else -> throw RuntimeException("")
            }
        }.apply {
            registerItemType(HomeItemType.TITLE.ordinal, R.layout.item_title)
            registerItemType(HomeItemType.NEWS.ordinal, R.layout.item_news)
            registerItemType(HomeItemType.MEDIATOR.ordinal, R.layout.item_mediator)
        }.let { multiTypeDelegate = it }
    }

    override fun convert(bvh: BVH, entity: Any) {
        when (entity) {
            is Title -> TitleItemRenderer(mContext).render(bvh, entity)
            is News -> NewsItemRenderer(mContext).render(bvh, entity)
            is Mediator -> MediatorItemRenderer(mContext).render(bvh, entity)
        }
    }

}

enum class HomeItemType {
    TOP,
    TITLE,
    NEWS,
    MEDIATOR
}