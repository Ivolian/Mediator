package com.unicorn.mediator.mediator.repository

import android.location.Location
import com.unicorn.mediator.mediator.model.entity.Mediator


interface MediatorRepository {

    fun get(): List<Mediator>

    fun get(location: Location): List<Mediator>

}