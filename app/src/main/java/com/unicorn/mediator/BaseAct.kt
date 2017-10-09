package com.unicorn.mediator

import activitystarter.ActivityStarter
import activitystarter.Arg
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marcinmoskala.activitystarter.argExtra

abstract class BaseAct : AppCompatActivity() {


    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        ActivityStarter.fill(this)
        injectDependencies()
        initView(savedInstanceState)
        bindPresenter()
    }

    abstract val layoutResId: Int

    abstract fun injectDependencies()

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun bindPresenter()

}