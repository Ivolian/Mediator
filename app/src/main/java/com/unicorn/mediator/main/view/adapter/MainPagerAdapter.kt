package com.unicorn.mediator.main.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.home.view.HomeFra
import com.unicorn.mediator.main.MainTabProvider.TABS
import com.unicorn.mediator.mediation.view.MediationFra
import com.unicorn.mediator.other.EmptyFraStarter


class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = TABS.size

    override fun getItem(position: Int): BaseFra = when (position) {
        0 -> HomeFra()
        4 -> MediationFra()
        else -> EmptyFraStarter.newInstance(TABS[position].third)
    }

}
