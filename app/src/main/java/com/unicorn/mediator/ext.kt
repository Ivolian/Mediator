package com.unicorn.mediator

import android.content.Intent
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import com.unicorn.mediator.app.view.BaseAct


/**
* Created by ivotai on 2017/10/9/009.
*/

fun BaseAct.startAct(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
}

fun BaseAct.color(@ColorRes id: Int) = ContextCompat.getColor(this, id)
