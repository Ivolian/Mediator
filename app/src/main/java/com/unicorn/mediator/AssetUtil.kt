package com.unicorn.mediator

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Created by ivotai on 2017/10/10/010.
 */
class AssetUtil {

    companion object {
        fun readJson(context: Context, fileName: String) = StringBuilder().apply {
            val bufferReader = BufferedReader(InputStreamReader(context.assets.open(fileName)))
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