package com.unicorn.mediator.mediator.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.AssetUtil
import com.unicorn.mediator.mediator.model.entity.Mediator


/**
 * Created by ivotai on 2017/10/10/010.
 */
class MediatorRepositoryImpl(private val context: Context) : MediatorRepository {

    override fun get(): List<Mediator> {
        val json = AssetUtil.readJson(context, "mediator.json")
        val type = object : TypeToken<List<Mediator>>() {}.type
        return Gson().fromJson<List<Mediator>>(json, type)
    }

}