package com.unicorn.mediator.app

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader


class AssetUtil {

    companion object {
        fun readJson(context: Context, assetName: String) =
                StringBuilder().apply {
                    val inputStream =context.assets.open(assetName)
                    val inputStreamReader = InputStreamReader(inputStream)
                    val bufferReader = BufferedReader(inputStreamReader)
                    while (true) {
                        val line = bufferReader.readLine()
                        if (line == null) {
                            break
                        } else {
                            append(line)
                        }
                    }
                }.toString()
    }

}