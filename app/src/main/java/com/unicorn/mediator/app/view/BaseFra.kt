package com.unicorn.mediator.app.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class BaseFra : Fragment() {

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        injectDependencies()
        initView(savedInstanceState)
        bindPresenter()
    }

    abstract val layoutResId: Int

    protected open fun injectDependencies() {}

    protected open fun initView(savedInstanceState: Bundle?) {}

    protected open fun bindPresenter() {}

}