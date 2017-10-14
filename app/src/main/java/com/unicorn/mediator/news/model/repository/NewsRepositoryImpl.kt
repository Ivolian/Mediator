package com.unicorn.mediator.news.model.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.app.AssetUtil
import com.unicorn.mediator.news.model.entity.News


class NewsRepositoryImpl(private val context: Context, private val gson: Gson) : NewsRepository {

    override fun get(): List<News> {
        val json = AssetUtil.readJson(context, "news.json")
        return gson.fromJson<List<News>>(json, object : TypeToken<List<News>>() {}.type)
    }

}