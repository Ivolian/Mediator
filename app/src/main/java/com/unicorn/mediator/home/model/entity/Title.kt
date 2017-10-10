package com.unicorn.mediator.home.model.entity

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.unicorn.mediator.home.model.HomeItemType


/**
 * Created by ivotai on 2017/10/10/010.
 */
class Title(var resId: Int, var title: String) : MultiItemEntity {
    override fun getItemType() = HomeItemType.TITLE.ordinal
}