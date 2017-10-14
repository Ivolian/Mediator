package com.unicorn.mediator.main.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.unicorn.mediator.home.view.HomeFra
import com.unicorn.mediator.main.MainTabProvider.TABS


class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = TABS.size

    override fun getItem(position: Int) = HomeFra()

}
