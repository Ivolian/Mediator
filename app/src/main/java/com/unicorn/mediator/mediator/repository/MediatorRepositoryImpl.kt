package com.unicorn.mediator.mediator.repository

import android.content.Context
import android.location.Location
import com.amap.api.maps.model.LatLng
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unicorn.mediator.app.AssetUtil
import com.unicorn.mediator.mediator.model.entity.Mediator
import java.util.*


class MediatorRepositoryImpl(private val context: Context, private val gson: Gson) : MediatorRepository {

    override fun get(): List<Mediator> {
        val json = AssetUtil.readJson(context, "mediator.json")
        return gson.fromJson<List<Mediator>>(json, object : TypeToken<List<Mediator>>() {}.type)
    }

    override fun get(location: Location) = get().apply {
        forEach { it.latLng = LatLng(location.latitude + dis(), location.longitude + dis()) }
    }

    private fun dis(): Double {
        val min = -0.02
        val max = 0.02
        return min + (max - min) * Random().nextDouble()
    }

}