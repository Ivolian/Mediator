package com.unicorn.mediator.news.model.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.app.AssetUtil
import com.unicorn.mediator.news.model.entity.News


class NewsRepositoryImpl(private var context: Context) : NewsRepository {

    override fun get(): List<News> {
        val json = AssetUtil.readJson(context, "news.json")
        return Gson().fromJson<List<News>>(json, object : TypeToken<List<News>>() {}.type)
    }

}