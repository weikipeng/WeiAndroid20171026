package com.jzb.android.pojo

import com.eduu.bang.BangApplication
import com.google.gson.annotations.SerializedName
import com.jzb.android.BaseDataListBehavior
import com.jzb.android.pro.IDataRecyclerView
import com.jzb.android.recyclerview.ViewHolderDivider

import java.util.ArrayList

/**
 * @since 6.5
 * 首页头条广告
 * Created by wikipeng on 2017/6/19.
 */
class STopNewsAdRes : BaseDataListBehavior() {
    var meta: Meta? = null
    /**
     * 首页头条广告列表
     */
    @SerializedName("objects")
    var adList: List<STopNewsAd>? = null

    val isEmpty: Boolean
        get() = adList == null || adList!!.size == 0


    ///////////////////////////////////////////////////////////////////////////
    //遍历广告
    ///////////////////////////////////////////////////////////////////////////
    //广告下标
    @Transient internal var adIndex = 0

    val homeTopic: SHomeTopic_6_5Res?
        get() {
            if (meta != null && meta!!.topicList != null && meta!!.topicList!!.size > 0) {
                val result = SHomeTopic_6_5Res()
                result.updateFrom(meta)
                return result
            }
            return null
        }

    val homeCard: SHomeTopicRes?
        get() {
            if (meta != null && (meta!!.readCard != null || meta!!.addon != null)) {
                val result = SHomeTopicRes()
                result.topicList = ArrayList<Any>()
                if (meta!!.readCard != null && meta!!.readCard!!.id > 0) {
                    result.topicList.add(meta!!.readCard)
                }

                if (meta!!.addon != null && meta!!.addon!!.id > 0) {
                    result.topicList.add(meta!!.addon)
                }
                return result
            }
            return null
        }

    fun handleErrorMessage(defaultErrorMessage: String, isIntercept: Boolean): Boolean {
        return false
    }

    fun getAd(adIndex: Int): STopNewsAd? {
        return if (adList != null && adIndex >= 0 && adList!!.size > adIndex) {
            adList!![adIndex]
        } else null
    }

    /**
     * 开始循环
     */
    fun resetLoop() {
        adIndex = 0
    }

    fun next(nowAdPosition: Int): STopNewsAd? {
        if (adList != null && adList!!.size > adIndex && adIndex >= 0) {
            val dataTopNewsAd = adList!![adIndex]
            adIndex++
            while (dataTopNewsAd == null || dataTopNewsAd!!.pos < nowAdPosition) {
                return next(nowAdPosition)
            }

            return dataTopNewsAd
        }
        return null
    }

    fun insertAdListIntoDataList(dataList: MutableList<IDataRecyclerView>, adapterPosition: Int): List<IDataRecyclerView> {
        //        DevLogTool.getInstance(BangApplication.getInstance()).saveLog(" ");
        //
        //        DevLogTool.getInstance(BangApplication.getInstance()).saveLog("start adIndex ===>" + adIndex
        //                + " adapterPosition:" + adapterPosition);

        var dataTopNewsAd = next(adapterPosition)
        val dataDivider = ViewHolderDivider.createDividerData(BangApplication.getInstance().getResources())

        var countAdapterPosition = adapterPosition
        var lastAdIndex = 0
        while (dataTopNewsAd != null && adapterPosition == dataTopNewsAd!!.pos) {

            dataTopNewsAd!!.adapterPosition = countAdapterPosition
            countAdapterPosition++

            ///////////////////////////////////////////////////////////////////////////
            //
            ///////////////////////////////////////////////////////////////////////////
            val topNewsAdViewData = dataTopNewsAd!!.build()
            if (topNewsAdViewData != null) {
                //                DevLogTool.getInstance(BangApplication.getInstance()).saveLog("显示 广告 adIndex ===>" + adIndex
                //                        + "     标题：" + dataTopNewsAd.title);
                dataList.add(topNewsAdViewData)
                dataList.add(dataDivider)
            }

            dataTopNewsAd = next(adapterPosition)
            lastAdIndex = adIndex
        }

        ///////////////////////////////////////////////////////////////////////////
        // 由于目前的算法 导致广告下标移动到了下一个广告 ，如果没有添加 或者添加过 需要移动回去上一个
        ///////////////////////////////////////////////////////////////////////////
        if (lastAdIndex > 0) {
            if (dataTopNewsAd != null) {
                adIndex = lastAdIndex
                adIndex--
            }
        } else if (adIndex > 0 && adList != null && adIndex <= adList!!.size) {
            adIndex--
        }

        //        DevLogTool.getInstance(BangApplication.getInstance()).saveLog("end adIndex ===>" + adIndex
        //                + (dataTopNewsAd != null ?
        //                " 下一个位置：" + dataTopNewsAd.pos + " 标题：" + dataTopNewsAd.title
        //                : ""));

        return dataList
    }


    ///////////////////////////////////////////////////////////////////////////
    // 6.6.1版本 为你读书（内容栏目）今日话题 统一在广告接口中返回
    ///////////////////////////////////////////////////////////////////////////
    class Meta : BaseMetaResult.Meta() {
        /**
         * 今日话题
         */
        @SerializedName("today_topic_data")
        var topicList: List<SHomeTopic_6_5>? = null
        @SerializedName("today_topic_count")
        var topicCount: Int = 0

        @SerializedName("today_topic_uri")
        var topicMoreUri: String? = null

        @SerializedName("today_topic_title")
        var topicMoreTitle: String? = null

        /**
         * 为你读书
         */
        @SerializedName("read")
        var readCard: SHomeTopic? = null

        var addon: SHomeTopic? = null
    }
}