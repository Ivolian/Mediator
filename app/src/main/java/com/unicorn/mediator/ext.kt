package com.unicorn.mediator

import android.content.Intent
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.unicorn.mediator.app.view.BaseAct
import com.unicorn.mediator.app.view.BaseFra
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration


fun BaseAct.startAct(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
}
fun BaseAct.startActAndFinish(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
    finish()
}
fun BaseFra.startAct(actClass: Class<*>) {
    startActivity(Intent(context, actClass))
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