package com.unicorn.mediator.home.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.unicorn.mediator.R
import com.unicorn.mediator.addDecor
import com.unicorn.mediator.app.inject.ComponentsHolder
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.home.model.entity.Top
import com.unicorn.mediator.home.presenter.HomePresenter
import com.unicorn.mediator.home.view.adapter.HomeAdapter
import com.unicorn.mediator.mediator.model.entity.Mediator
import kotlinx.android.synthetic.main.fra_home.*


class HomeFra : BaseFra(), HomeView {

    override val layoutResId = R.layout.fra_home

    override fun initView(savedInstanceState: Bundle?) {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val topCount = 4
        val spanCount = 2
        recyclerView.apply {
            homeAdapter.setSpanSizeLookup { _, pos -> if (pos < topCount) 1 else spanCount }
            layoutManager = GridLayoutManager(context, spanCount)
            adapter = homeAdapter
            addDecor()
        }
    }

    private val presenter by lazy { HomePresenter(this, ComponentsHolder.appComponent.getHomeRepository()) }

    override fun bindPresenter() {
        presenter.onViewCreated()
        homeAdapter.apply {
            setOnItemChildClickListener { _, _, pos ->
                getItem(pos).apply {
                    if (this is Mediator) {
                        presenter.applyForMediation(this)
                    }
                    if (this is Top && this.text == "找调解员") {
                        presenter.lookForMediator()
                    }
                }
            }
        }
    }

    private var homeAdapter = HomeAdapter()

    override fun render(list: List<Any>) {
        homeAdapter.setNewData(list)
    }

}
