package com.unicorn.mediator

import android.content.Intent
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.unicorn.mediator.app.view.BaseAct
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration


/**
 * Created by ivotai on 2017/10/9/009.
 */

fun BaseAct.startAct(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
}

fun BaseAct.color(@ColorRes id: Int) = ContextCompat.getColor(this, id)

fun RecyclerView.addDecor() {
    addItemDecoration(
            HorizontalDividerItemDecoration.Builder(this.context)
                    .colorResId(R.color.md_grey_300)
                    .size(1)
                    .build()
    )
}