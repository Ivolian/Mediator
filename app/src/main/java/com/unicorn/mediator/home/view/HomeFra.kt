package com.unicorn.mediator.home.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.unicorn.mediator.R
import com.unicorn.mediator.addDecor
import com.unicorn.mediator.app.inject.ComponentsHolder
import com.unicorn.mediator.app.view.BaseFra
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
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
            addDecor()
        }
    }

    private val presenter by lazy { HomePresenter(this, ComponentsHolder.appComponent.getHomeRepository()) }

    override fun bindPresenter() {
        presenter.onViewCreated()
        homeAdapter.setOnItemChildClickListener { _, _, pos ->
            homeAdapter.getItem(pos).apply {
                if (this is Mediator){
                    presenter.applyForMediation(this)
                }
            }
        }
    }

    private var homeAdapter = HomeAdapter()

    override fun render(list: List<Any>) {
        homeAdapter.setNewData(list)
    }
}
