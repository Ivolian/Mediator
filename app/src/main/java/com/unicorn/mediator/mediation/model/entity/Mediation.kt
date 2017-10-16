package com.unicorn.mediator.mediation.model.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
class Mediation(
        @Id
        var _id: Long = 0,
        var acceptor: String,
        var applicant: String,
        var respondent: String,
        var caseType: String,
        var caseTitle: String,
        var caseAddress: String,
        var documentType: String,
        var documentNum: String,
        var mediationStatus: String
)

