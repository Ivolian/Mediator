package com.unicorn.mediator.mediation.model.repository

import com.unicorn.mediator.mediation.model.entity.Mediation


interface MediationRepository {

    fun put(mediation: Mediation)

}

