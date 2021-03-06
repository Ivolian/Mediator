package com.unicorn.mediator.app.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract class BaseAct : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        injectDependencies()
        initView(savedInstanceState)
        bindPresenter()
    }

    abstract val layoutResId: Int

    protected open fun injectDependencies() {}

    protected open fun initView(savedInstanceState: Bundle?) {}

    protected open fun bindPresenter() {}

}