package com.unicorn.mediator.mediator.repository

import com.unicorn.mediator.mediator.model.entity.Mediator


/**
 * Created by ivotai on 2017/10/10/010.
 */
interface MediatorRepository {

    fun get(): List<Mediator>

}