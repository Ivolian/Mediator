package com.unicorn.mediator.main

import android.os.Bundle
import android.support.annotation.DrawableRes
import com.unicorn.mediator.R
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.color
import kotlinx.android.synthetic.main.act_main.*
import me.majiajie.pagerbottomtabstrip.item.NormalItemView


class MainAct : BaseAct() {

    override val layoutResId = R.layout.act_main

    override fun injectDependencies() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        initTab()
//        StatusBarCompat.translucentStatusBar(this
    }

    private fun initTab() {
        val navigationController = tab.custom()
                .addItem(newItem(R.mipmap.home_unchecked, R.mipmap.home_checked, "首页"))
                .addItem(newItem(R.mipmap.mediateapply_unchecked, R.mipmap.mediateapply_checked, "申请调解"))
                .addItem(newItem(R.mipmap.message_unchecked, R.mipmap.message_checked, "消息"))
                .addItem(newItem(R.mipmap.coshow_unchecked, R.mipmap.coshow_checked, "朋友圈"))
                .addItem(newItem(R.mipmap.my_unchecked, R.mipmap.my_checked, "个人"))
                .build()
    }

    private fun newItem(@DrawableRes drawable: Int, @DrawableRes checkedDrawable: Int, title: String) = NormalItemView(this).apply {
        initialize(drawable, checkedDrawable, title)
        setTextDefaultColor(color(R.color.md_grey_600))
        setTextCheckedColor(color(R.color.colorAccent))
    }

    override fun bindPresenter() {
    }
}
