package com.unicorn.mediator.news.model.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.news.model.entity.News
import java.io.BufferedReader
import java.io.InputStreamReader


/*
 Created by ivotai on 2017/10/9/009.
*/
class NewsRepositoryImpl(private var context: Context) : NewsRepository {

    override fun get(): List<News> {
        val json = readJson()
        val type = object : TypeToken<List<News>>() {}.type.javaClass
        return Gson().fromJson<List<News>>(json, type)
    }

    private fun readJson(): String {
        val fileName = "news.json"
        val bufferReader = BufferedReader(InputStreamReader(context.assets.open(fileName)))
        val stringBuilder = StringBuilder()
        while (true) {
            val line = bufferReader.readLine()
            if (line == null) {
                break
            } else {
                stringBuilder.append(line)
            }
        }
        return stringBuilder.toString()
    }


}