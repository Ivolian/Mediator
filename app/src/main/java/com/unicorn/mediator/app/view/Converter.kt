package com.unicorn.mediator.app.view

import com.unicorn.mediator.app.view.adapter.BVH


interface Converter<in T> {

    fun convert(bvh: BVH, entity: T)

}