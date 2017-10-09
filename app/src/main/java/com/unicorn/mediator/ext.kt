package com.unicorn.mediator

import android.content.Intent

/**
 * Created by Administrator on 2017/10/9/009.
 */

fun BaseAct.startAct(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
}
