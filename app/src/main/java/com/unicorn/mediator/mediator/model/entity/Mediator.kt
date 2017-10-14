package com.unicorn.mediator.mediator.model.entity

/**
 * Created by ivotai on 2017/10/10/010.
 */

data class Mediator(
		val id: String, //30078
		val orderno: String, //000009
		val shifouzhiding: String, //0
		val quanzhong: String, //0
		val yonghuleixing: String, //2
		val diaojieyuanleixing: String, //2
		val gongyijijin: String,
		val shenhezhuangtai: String, //2
		val yonghuzhuangtai: String, //1
		val name: String, //祁朝波
		val nichen: String, //祁朝波
		val phone: String, //18315266162
		val lianxidianhua: String,
		val yanzhengma: String,
		val xingbie: String, //1
		val shengri: String,
		val yue: String,
		val suozaidiqu: String,
		val jiedao: String,
		val xiangxidizhi: String, //酉阳
		val zhiye: String,
		val nianxian: String, //31
		val zigezhengbianhao: String,
		val diaoweihui: String, //桃花源街道人民调解委员会
		val diaoweihuiquyu: String,
		val zonghepingfen: String, //0
		val guanliyuanpingfen: String,
		val diaojiechenggonglv: String,
		val diaojieanjianshu: String,
		val biaoqian: String, //12,7,9
		val gerenjianjie: String,
		val zhiyelvshizigezhengz: String,
		val touxiang: String,
		val jingdu: String, //108.28723717337
		val weidu: String, //30.811852
		val qq_only: String,
		val weixin_only: String,
		val attr: Attr,
		val yonghuleixing_replace: String, //调解员
		val diaojieyuanleixing_replace: String, //调解员
		val gongyijijin_replace: String,
		val shenhezhuangtai_replace: String, //审核通过
		val shengri_replace: String,
		val biaoqian_replace: String, //山林土地,房产纠纷,征地拆迁
		val yonghuleixing_really: String, //2
		val djs_anjian_num: String, //14
		val tjz_anjian_num: Int //0
)

data class Attr(
		val touxiang: List<Touxiang>
)

data class Touxiang(
		val id: String, //2975
		val fieldname: String, //touxiang
		val upname: Any, //null
		val filesize: Any, //null
		val isremote: String, //1
		val domain: String, //http://lanneretcdn.iusworks.com/0eafe620-c83a-4037-832b-0bbd478d687d.jpg
		val filesuffix: Any, //null
		val attached: String //http://lanneretcdn.iusworks.com/0eafe620-c83a-4037-832b-0bbd478d687d.jpg
)