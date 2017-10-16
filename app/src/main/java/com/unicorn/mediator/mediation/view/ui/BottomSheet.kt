package com.unicorn.mediator.mediation.view.ui

import activitystarter.Arg
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.marcinmoskala.activitystarter.argExtra
import com.unicorn.mediator.R
import com.weigan.loopview.LoopView
import me.shaohui.bottomdialog.BottomDialog


class BottomSheet : BottomDialog() {

    @get:Arg
    val title: String by argExtra()

    @get:Arg
    val items: ArrayList<String> by argExtra()

    override fun getLayoutRes() = R.layout.view_bottom_sheet

    override fun getDimAmount() = 0.3f

    override fun bindView(view: View) {
        view.findViewById<TextView>(R.id.tvTitle).text = title
        view.findViewById<LoopView>(R.id.loopView).apply {
            setNotLoop()
            setTextSize(20f)
            setItems(items)
            setListener { pos = it }
        }
        view.findViewById<TextView>(R.id.tvCancel).setOnClickListener { dismiss() }
        view.findViewById<TextView>(R.id.tvConfirm).setOnClickListener {
            listener?.onConfirm(pos)
            dismiss()
        }
    }

    var pos = 0
    var listener: BottomSheetListener? = null
}


interface BottomSheetListener {
    fun onConfirm(pos: Int)
}


