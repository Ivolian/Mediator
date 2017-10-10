package com.unicorn.mediator.app.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class BaseFra : Fragment() {

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutResId, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        injectDependencies()
        initView(savedInstanceState)
        bindPresenter()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
    abstract val layoutResId: Int

    abstract fun injectDependencies()

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun bindPresenter()

}