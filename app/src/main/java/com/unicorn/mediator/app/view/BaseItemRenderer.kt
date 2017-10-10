package com.unicorn.mediator.app.view

import com.unicorn.mediator.app.view.adapter.BVH


/**
 * Created by ivotai on 2017/10/10/010.
 */
interface BaseItemRenderer<in T> {

    fun render(bvh: BVH, t: T)

}