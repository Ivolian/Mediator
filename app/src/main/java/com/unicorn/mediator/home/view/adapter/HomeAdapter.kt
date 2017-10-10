package com.unicorn.mediator.home.view.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.adapter.BVH
import com.unicorn.mediator.home.model.HomeItemType
import com.unicorn.mediator.home.model.entity.Title
import com.unicorn.mediator.home.view.renderer.TitleItemRenderer
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.view.MediatorItemRenderer
import com.unicorn.mediator.news.model.entity.News
import com.unicorn.mediator.news.view.NewsItemRenderer


/**
 * Created by ivotai on 2017/10/10/010.
 */
class HomeAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BVH>(null) {

    init {
        addItemType(HomeItemType.TITLE.ordinal, R.layout.item_title)
        addItemType(HomeItemType.NEWS.ordinal, R.layout.item_news)
        addItemType(HomeItemType.MEDIATOR.ordinal, R.layout.item_mediator)
    }

    override fun convert(bvh: BVH, item: MultiItemEntity) {
        when (bvh.itemViewType) {
            HomeItemType.TITLE.ordinal -> TitleItemRenderer(mContext).render(bvh, item as Title)
            HomeItemType.NEWS.ordinal -> NewsItemRenderer(mContext).render(bvh, item as News)
            HomeItemType.MEDIATOR.ordinal -> MediatorItemRenderer(mContext).render(bvh, item as Mediator)
        }
    }

}


