package com.unicorn.mediator.mediation.model.constant


enum class MediationStatus(val displayName: String) {
    Checking("待审核"),
    Mediating("调解中"),
    Complete("已完成"),
    Cancel("已取消")
}