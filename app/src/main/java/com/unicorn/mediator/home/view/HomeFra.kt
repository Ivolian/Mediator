package com.unicorn.mediator.home.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.unicorn.mediator.R
import com.unicorn.mediator.addDecor
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.home.presenter.HomePresenterImpl
import com.unicorn.mediator.home.repository.HomeRepositoryImpl
import com.unicorn.mediator.home.view.adapter.HomeAdapter
import com.unicorn.mediator.mediator.repository.MediatorRepositoryImpl
import com.unicorn.mediator.news.model.repository.NewsRepositoryImpl
import kotlinx.android.synthetic.main.fra_home.*


class HomeFra : BaseFra(), HomeView {

    override val layoutResId = R.layout.fra_home

    override fun injectDependencies() {

    }

    var homeAdapter = HomeAdapter()

    override fun initView(savedInstanceState: Bundle?) {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
            addDecor()
        }
    }

    private val presenter by lazy {
        HomePresenterImpl(this, HomeRepositoryImpl(NewsRepositoryImpl(context), MediatorRepositoryImpl(context)))
    }

    override fun bindPresenter() {
        presenter.onViewCreated()
//        mediatorAdapter.setOnItemChildClickListener { _, _, position ->
//            mediatorAdapter.getItem(position)?.let { presenter.onApplyMediation(it) }
//        }
    }

    override fun render(list: List<Any>) {
        homeAdapter.setNewData(list)
    }
}
