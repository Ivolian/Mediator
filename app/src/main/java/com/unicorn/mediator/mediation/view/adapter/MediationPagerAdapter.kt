package com.unicorn.mediator.mediation.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.mediation.model.constant.MediationStatus
import com.unicorn.mediator.mediation.view.MediationListFraStarter


class MediationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mediationStatus = MediationStatus.values()

    override fun getCount() = mediationStatus.size

    override fun getPageTitle(position: Int) = mediationStatus[position].displayName

    override fun getItem(position: Int): BaseFra =
            MediationListFraStarter.newInstance(mediationStatus[position].name)

}