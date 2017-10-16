package com.unicorn.mediator.mediation.view

import activitystarter.Arg
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.marcinmoskala.activitystarter.argExtra
import com.unicorn.mediator.R
import com.unicorn.mediator.app.inject.ComponentsHolder
import com.unicorn.mediator.app.view.BaseFra
import com.unicorn.mediator.mediation.view.adapter.MediationAdapter
import kotlinx.android.synthetic.main.fra_meidation_list.*

class MediationListFra : BaseFra() {

    @get:Arg
    val mediationStatusName: String by argExtra()

    override val layoutResId = R.layout.fra_meidation_list

    private val mediationAdapter = MediationAdapter()

    private val repo = ComponentsHolder.appComponent.getMediationRepository()

    override fun initView(savedInstanceState: Bundle?) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        mediationAdapter.apply {
            bindToRecyclerView(recyclerView)
            setEmptyView(R.layout.view_empty)
        }
        repo.get(mediationStatusName).let { mediationAdapter.setNewData(it) }
        mediationAdapter.setOnItemClickListener { _, _, pos ->
            mediationAdapter.getItem(pos).let {
                MediationDetailActStarter.start(context, it)
            }
        }
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeRefreshLayout.setOnRefreshListener {
            repo.get(mediationStatusName).let { mediationAdapter.setNewData(it) }
            swipeRefreshLayout.isRefreshing = false
        }
    }

}