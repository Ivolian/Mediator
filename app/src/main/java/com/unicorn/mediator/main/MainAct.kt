package com.unicorn.mediator.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.color
import kotlinx.android.synthetic.main.act_main.*
import me.majiajie.pagerbottomtabstrip.item.NormalItemView


class MainAct : BaseAct() {

    override val layoutResId = R.layout.act_main

    private val tabs = listOf(
            Triple(R.mipmap.home_unchecked, R.mipmap.home_checked, "首页"),
            Triple(R.mipmap.mediateapply_unchecked, R.mipmap.mediateapply_checked, "申请调解"),
            Triple(R.mipmap.message_unchecked, R.mipmap.message_checked, "消息"),
            Triple(R.mipmap.coshow_unchecked, R.mipmap.coshow_checked, "朋友圈"),
            Triple(R.mipmap.my_unchecked, R.mipmap.my_checked, "个人")
    )

    override fun initView(savedInstanceState: Bundle?) {
        initTab(initViewPager())
    }

    private fun initViewPager() = viewPager.apply {
        offscreenPageLimit = tabs.size - 1
        adapter = MainPagerAdapter(supportFragmentManager)
    }

    private fun initTab(vp: ViewPager) {
        tab.custom().apply {
            for (tab in tabs) {
                addItem(NormalItemView(this@MainAct).apply {
                    initialize(tab.first, tab.second, tab.third)
                    setTextDefaultColor(color(R.color.md_grey_600))
                    setTextCheckedColor(color(R.color.colorAccent))
                })
            }
        }.build().setupWithViewPager(vp)
    }

}
