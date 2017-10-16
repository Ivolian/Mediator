package com.unicorn.mediator.mediation.model.repository

import com.unicorn.mediator.mediation.model.entity.Mediation
import io.objectbox.Box


class MediationRepositoryImpl(private val box: Box<Mediation>) : MediationRepository {

    override fun put(mediation: Mediation) {
        box.put(mediation)
    }

}