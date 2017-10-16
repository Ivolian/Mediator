package com.unicorn.mediator.mediation.model.repository

import com.unicorn.mediator.mediation.model.entity.Mediation
import com.unicorn.mediator.mediation.model.entity.Mediation_
import io.objectbox.Box


class MediationRepositoryImpl(private val box: Box<Mediation>) : MediationRepository {

    override fun put(mediation: Mediation) {
        box.put(mediation)
    }

    override fun get(mediationStatusName: String): List<Mediation> {
        return box.query()
                .equal(Mediation_.mediationStatusName, mediationStatusName)
                .build().find()
    }

}