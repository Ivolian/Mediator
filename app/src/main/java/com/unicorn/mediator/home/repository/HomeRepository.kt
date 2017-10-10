package com.unicorn.mediator.home.repository

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by ivotai on 2017/10/10/010.
 */
interface HomeRepository {

    fun get(): List<MultiItemEntity>

}