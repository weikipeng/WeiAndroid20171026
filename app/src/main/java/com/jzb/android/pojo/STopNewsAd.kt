package com.jzb.android.pojo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils

import com.eduu.bang.thread.ThreadActivity
import com.google.gson.annotations.SerializedName
import com.jzb.android.classroom.CourseDetailActivity
import com.jzb.android.component.topnews.ad.VHTopNewsADBusinessBig
import com.jzb.android.component.topnews.ad.VHTopNewsADBusinessSmall
import com.jzb.android.component.topnews.ad.VHTopNewsADClassroom
import com.jzb.android.component.topnews.ad.VHTopNewsADSubject
import com.jzb.android.component.topnews.ad.VHTopNewsADThread
import com.jzb.android.component.topnews.video.ViewDataTopNewsVideo
import com.jzb.android.pro.DataRecyclerView
import com.jzb.android.pro.IDataRecyclerView
import com.jzb.android.util.JzbUrlJump
import com.jzb.android.v2.home.mainpage.viewholder.VHTopNewsVideo

/**
 * @since 6.5
 * 首页头条广告
 * Created by wikipeng on 2017/6/19.
 *
 *
 * id: ID,
 * title: 标题,
 * intro: 摘要,
 * uri_type: 跳转类型 (0: Native, 1: Webview 2: 手机浏览器 3: 不跳转)
 * uri: 跳转地址,
 * ad_type: 广告类型 (0: 帖子广告 1: 课程广告 2: 商业广告(大图) 3: 商业广告(小图) 4: 专题广告),
 * image: 图片地址
 * pos: 位置,
 * forum_title: 版块标题（只有帖子类型的广告才使用）,
 * forum_uri: 版块跳转地址，例: com.eduu.bang.thread:1000（只有帖子类型的广告才使用）
 */
class STopNewsAd {
    /**
     * ad_type : 0
     * forum_uri : com.eduu.forum:2001
     * title : 北京广告
     * image :
     * pos : 1
     * uri : com.eduu.bang.thread:1000
     * intro : 北京广告摘要
     * forum_title : 北京版块
     * id : 1
     * uri_type : 0
     */

    @SerializedName("ad_type")
    var adType: Int = 0
    @SerializedName("forum_uri")
    var forumUri: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("pos")
    var pos: Int = 0
    @SerializedName("uri")
    var uri: String? = null
    @SerializedName("intro")
    var intro: String? = null
    @SerializedName("forum_title")
    var forumTitle: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("uri_type")
    var uriType: Int = 0

    /**
     * 是否显示广告图标
     */
    @SerializedName("ad_icon")
    var isShowAdFlag: Boolean = false

    ///////////////////////////////////////////////////////////////////////////
    // 6.7 视频时长
    ///////////////////////////////////////////////////////////////////////////
    /**
     * 视频时长
     */
    var duration: String? = null
    /**
     * 浏览数
     */
    @SerializedName("views")
    var visitCount: Int = 0

    var adapterPosition: Int = 0

    fun build(): IDataRecyclerView? {
        var result: IDataRecyclerView? = null
        when (adType) {
            TYPE_THREAD -> result = DataRecyclerView.create(VHTopNewsADThread.TYPE_TOP_NEWS_AD_THREAD, this)
            TYPE_BUSINESS_BIG -> result = DataRecyclerView.create(VHTopNewsADBusinessBig.TYPE_TOP_NEWS_AD_BUSINESS_BIG, this)
            TYPE_BUSINESS_SMALL -> result = DataRecyclerView.create(VHTopNewsADBusinessSmall.TYPE_TOP_NEWS_AD_BUSINESS_SMALL, this)
            TYPE_CLASSROOM -> result = DataRecyclerView.create(VHTopNewsADClassroom.TYPE_TOP_NEWS_AD_CLASSROOM, this)
            TYPE_SUBJECT -> result = DataRecyclerView.create(VHTopNewsADSubject.TYPE_TOP_NEWS_AD_SUBJECT, this)
            TYPE_VIDEO -> {
                val viewDataTopNewsVideo = ViewDataTopNewsVideo()
                viewDataTopNewsVideo.updateFrom(this)

                result = DataRecyclerView.create(VHTopNewsVideo.TYPE_TOP_NEWS_VIDEO, viewDataTopNewsVideo)
            }
        }
        return result
    }

    fun handleNativeAction(context: Context) {
        when (adType) {
            TYPE_THREAD -> if (!TextUtils.isEmpty(uri) && TextUtils.isDigitsOnly(uri)) {
                val id = java.lang.Long.parseLong(uri)
                ThreadActivity.Builder(context, id).startActivity()
            } else {
                uriType = URI_TYPE_WEB_APP
                handleAction(context)
            }
            TYPE_CLASSROOM -> if (!TextUtils.isEmpty(uri) && TextUtils.isDigitsOnly(uri)) {
                val id = java.lang.Long.parseLong(uri)
                CourseDetailActivity.start(context, id)
            } else {
                uriType = URI_TYPE_WEB_APP
                handleAction(context)
            }
            else -> {
                uriType = URI_TYPE_WEB_APP
                handleAction(context)
            }
        }
    }

    fun handleAction(context: Context) {
        when (uriType) {
            URI_TYPE_WEB_APP -> if (!TextUtils.isEmpty(uri)) {
                JzbUrlJump.urlParse(context, uri)
            }
            URI_TYPE_BROWSER -> if (!TextUtils.isEmpty(uri)) {
                var tUri = Uri.parse(uri)
                if (!tUri.isHierarchical) {
                    tUri = Uri.parse("http:" + uri!!)
                }

                val intent = Intent(Intent.ACTION_VIEW, tUri)
                context.startActivity(intent)
            }
            URI_TYPE_NATIVE -> handleNativeAction(context)
        }
    }

    companion object {
        /**
         * 帖子广告
         */
        val TYPE_THREAD = 0
        /**
         * 课程广告
         */
        val TYPE_CLASSROOM = 1
        /**
         * 商业广告(大图)
         */
        val TYPE_BUSINESS_BIG = 2
        /**
         * 商业广告(小图)
         */
        val TYPE_BUSINESS_SMALL = 3
        /**
         * 专题广告
         */
        val TYPE_SUBJECT = 4

        /**
         * 视频广告
         */
        val TYPE_VIDEO = 5

        ///////////////////////////////////////////////////////////////////////////
        // 跳转类型
        ///////////////////////////////////////////////////////////////////////////
        val URI_TYPE_NATIVE = 0
        val URI_TYPE_WEB_APP = 1
        val URI_TYPE_BROWSER = 2
        val URI_TYPE_NONE = 3
    }
}