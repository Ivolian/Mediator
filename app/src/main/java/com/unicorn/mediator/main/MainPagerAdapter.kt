package com.unicorn.mediator.main

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.unicorn.mediator.home.view.HomeFra


class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = HomeFra()

    override fun getCount() = 5

}
