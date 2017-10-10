package com.unicorn.mediator.home.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.unicorn.mediator.R
import com.unicorn.mediator.addDecor
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.home.presenter.HomePresenterImpl
import com.unicorn.mediator.mediator.model.entity.Mediator
import com.unicorn.mediator.mediator.repository.MediatorRepositoryImpl
import com.unicorn.mediator.mediator.view.MediatorView
import com.unicorn.mediator.mediator.view.adapter.MediatorAdapter
import com.unicorn.mediator.news.model.entity.News
import com.unicorn.mediator.news.model.repository.NewsRepositoryImpl
import com.unicorn.mediator.news.view.NewsView
import com.unicorn.mediator.news.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fra_home.*


class HomeFra : BaseFra(), NewsView, MediatorView {

    override val layoutResId = R.layout.fra_home

    override fun injectDependencies() {

    }

    private val newsAdapter = NewsAdapter()
    private val mediatorAdapter = MediatorAdapter()

    override fun initView(savedInstanceState: Bundle?) {
        with(rvNews) {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
            addDecor()
        }
        with(rvMediator) {
            layoutManager = LinearLayoutManager(context)
            adapter = mediatorAdapter
            addDecor()
        }
    }

    private val presenter by lazy {
        HomePresenterImpl(
                this, NewsRepositoryImpl(context),
                this, MediatorRepositoryImpl(context)
        )
    }

    override fun bindPresenter() {
        presenter.onViewCreated()
        mediatorAdapter.setOnItemChildClickListener { _, _, position ->
            mediatorAdapter.getItem(position)?.let { presenter.onApplyMediation(it) }
        }
    }

    override fun renderNewsList(newsList: List<News>) {
        newsAdapter.setNewData(newsList)
    }

    override fun renderMediators(mediators: List<Mediator>) {
        mediatorAdapter.setNewData(mediators)
    }
}
