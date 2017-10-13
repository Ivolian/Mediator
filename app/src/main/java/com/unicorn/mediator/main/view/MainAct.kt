package com.unicorn.mediator.main.view

import android.os.Bundle
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.color
import com.unicorn.mediator.main.TabProvider.TABS
import com.unicorn.mediator.main.view.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.act_main.*
import me.majiajie.pagerbottomtabstrip.item.NormalItemView


class MainAct : BaseAct() {

    override val layoutResId = R.layout.act_main

    override fun initView(savedInstanceState: Bundle?) {
        initViewPager()
        initTab()
    }

    private fun initViewPager() {
        with(viewPager, {
            offscreenPageLimit = TABS.size - 1
            adapter = MainPagerAdapter(supportFragmentManager)
        })
    }

    private fun initTab() {
        tab.custom().apply {
            for (it in TABS) {
                addItem(NormalItemView(this@MainAct).apply {
                    initialize(it.first, it.second, it.third)
                    setTextDefaultColor(color(R.color.md_grey_600))
                    setTextCheckedColor(color(R.color.colorAccent))
                })
            }
        }.build().setupWithViewPager(viewPager)
    }

}
