package com.unicorn.mediator.news.model.entity


class News(
        val id: String, //115
        val name: String, //这个国庆开始实施的新政新规!
        val suoluetu: List<Suoluetu>,
        val liulanliang: String, //11
        val createtime: String, //1507531474
        val narong: String,
        val shifushipin: String, //0
        val leixing: String, //1
        val createtime_replace: String, //2017-10-09
        val narong_replace: String,
        val shifushipin_replace: String, //否
        val leixing_replace: String //快讯
)

class Suoluetu(
        val id: String, //25450
        val fieldname: String, //suoluetu
        val upname: String, //21.jpg
        val filesize: String, //80.78kb
        val isremote: String, //0
        val domain: Any, //null
        val filesuffix: String, //jpg
        val attached: String //http://54.223.181.24:81/Public/Uploads/MisAutoVyc/2017/10/09/59db18aa2926b.jpg
)
