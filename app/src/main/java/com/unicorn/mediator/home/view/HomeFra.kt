package com.unicorn.mediator.home.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.unicorn.mediator.R
import com.unicorn.mediator.addDecor
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.home.presenter.HomePresenterImpl
import com.unicorn.mediator.news.model.entity.News
import com.unicorn.mediator.news.model.repository.NewsRepositoryImpl
import com.unicorn.mediator.news.view.NewsView
import com.unicorn.mediator.news.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fra_home.*


class HomeFra : BaseFra(), NewsView {

    override val layoutResId = R.layout.fra_home

    override fun injectDependencies() {

    }

    private val newsAdapter = NewsAdapter()

    override fun initView(savedInstanceState: Bundle?) {
        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.adapter = newsAdapter
        rvNews.addDecor()
    }


    private val presenter by lazy { HomePresenterImpl(this, NewsRepositoryImpl(context)) }
    override fun bindPresenter() {
        presenter.onViewCreated()
    }

    override fun render(newsList: List<News>) {
        newsAdapter.setNewData(newsList)
    }

}
