package com.unicorn.mediator.mediation.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.mediation.MediationListFra
import com.unicorn.mediator.mediation.model.constant.MediationStatus


class MediationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val status = MediationStatus.values()

    override fun getCount() = status.size

    override fun getPageTitle(position: Int) = status[position].displayName

    override fun getItem(position: Int): BaseFra = MediationListFra()

}