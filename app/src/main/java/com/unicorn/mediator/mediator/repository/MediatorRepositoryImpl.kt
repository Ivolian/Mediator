package com.unicorn.mediator.mediator.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.app.AssetUtil
import com.unicorn.mediator.mediator.model.entity.Mediator


class MediatorRepositoryImpl(private val context: Context, private val gson: Gson) : MediatorRepository {

    override fun get(): List<Mediator> {
        val json = AssetUtil.readJson(context, "mediator.json")
        return gson.fromJson<List<Mediator>>(json,  object : TypeToken<List<Mediator>>() {}.type)
    }

}