package com.eduu.bang

//import android.app.Activity
//import android.app.ActivityManager
//import android.app.ActivityManager.RunningAppProcessInfo
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.os.Process
//import android.os.StrictMode
//import android.support.multidex.MultiDex
//import android.text.TextUtils
//import android.webkit.CookieSyncManager
//
//import com.eduu.bang.component.LoginThirdPartyComponent
//import com.eduu.bang.event.PushEvent
//import com.eduu.bang.http.HttpManager
//import com.eduu.bang.model.QQItem
//import com.eduu.bang.model.SinaItem
//import com.eduu.bang.model.ThreadDraft
//import com.eduu.bang.model.UserItem
//import com.eduu.bang.model.WeiXinItem
//import com.eduu.bang.util.ActivityUtility
//import com.eduu.bang.util.AppSettings
//import com.eduu.bang.util.ThreadDraftStorage
//import com.eduu.bang.util.ThreadPublisher
//import com.google.android.gms.analytics.GoogleAnalytics
//import com.google.android.gms.analytics.HitBuilders
//import com.google.android.gms.analytics.Tracker
//import com.jzb.android.AppStartManager
//import com.jzb.android.component.ShareComponent
//import com.jzb.android.component.push.PushChannelHelper
//import com.jzb.android.component.upgrade.AppUpgrade
//import com.jzb.android.event.EventManager
//import com.jzb.android.util.DevelopUtil
//import com.jzb.android.util.DomainUtil
//import com.jzb.android.util.JZBPopupDialog
//import com.jzb.android.util.JZBReportPrimer
//import com.jzb.android.util.JZBReportSender
//import com.pobear.BaseApplication
//import com.pobear.BaseHttpClient
//import com.pobear.RestfulClient
//import com.tal.authedsdk.ImplicitAuthCallBack
//import com.tal.authedsdk.TALUnifiedLoginAuthedManager
//import com.tencent.mm.sdk.openapi.IWXAPI
//import com.tencent.mm.sdk.openapi.WXAPIFactory
//import com.weiauto.develop.activity.ActivityStackManager
//import com.weiauto.develop.tool.FCloseLog
//import com.weiauto.develop.tool.FOpenLog
//
//import org.acra.ACRA
//import org.acra.ReportingInteractionMode
//import org.acra.annotation.ReportsCrashes
//import org.greenrobot.eventbus.EventBus
//import org.greenrobot.eventbus.Subscribe

import android.app.Application

//@ReportsCrashes(
////        formUri = "http://yourserver.com/yourscript",
//        mailTo = "wiki.peng@qq.com",
//        customReportContent = {ReportField.APP_VERSION_CODE
//                , ReportField.APP_VERSION_NAME
//                , ReportField.ANDROID_VERSION
//                , ReportField.PHONE_MODEL
//                , ReportField.CUSTOM_DATA
//                , ReportField.PRODUCT
//                , ReportField.BUILD
//                , ReportField.STACK_TRACE
//                , ReportField.LOGCAT
//        }
//        , mode = ReportingInteractionMode.TOAST
//        , resToastText = R.string.crash_toast_text
//)
//@ReportsCrashes(mode = ReportingInteractionMode.SILENT, reportSenderFactoryClasses = { com.jzb.android.util.JZBReportSenderFactory.class }, reportPrimerClass = JZBReportPrimer::class)
class BangApplication : Application() {
//    var appStartTime: Long = 0
//    var IS_HOME_GUIDE_SHOW = false
//    var IS_NOTIFY_PERMISSION_GUIDE_SHOW = false
//    /**
//     * 好未来（培优）第三方账号授权管理
//     */
//    protected var talUnifiedLoginAuthedManager: TALUnifiedLoginAuthedManager
//    private var mTracker: Tracker? = null
//    var sinaItem: SinaItem? = null // 微博资料信息
//    var qqItem: QQItem? = null // QQ资料信息
//    var wxItem: WeiXinItem? = null // QQ资料信息
//    var isHadShowSeeUserDialog = false
//    var applicationModule: ApplicationModule? = null
//        private set
//    var applicationParam: ApplicationParam? = null
//        private set
//    var jzbPopupDialog: JZBPopupDialog? = null
//        private set
//
//    // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
//    val defaultTracker: Tracker
//        @Synchronized get() {
//            if (mTracker == null) {
//                val analytics = GoogleAnalytics.getInstance(this)
//                mTracker = analytics.newTracker(R.xml.global_tracker)
//            }
//            return mTracker
//        }
//
//    val draftStorage: ThreadDraftStorage
//        get() = applicationModule!!.mDraftStorage
//
//
//    val userInfo: UserItem?
//        @Deprecated("use getInstanceUser() in AppSettings")
//        get() = applicationModule!!.mAppSettings.getUser()
//
//    val isUserHasMobile: Boolean
//        get() {
//            var result = false
//            if (userInfo != null && !TextUtils.isEmpty(userInfo!!.mobile)) {
//                result = true
//            }
//            return result
//        }
//
//    val appSettings: AppSettings
//        get() = applicationModule!!.mAppSettings
//
//    val cacheValuableSettings: CacheValuableSettings
//        get() = applicationModule!!.mCacheValuableSettings
//
//    val userLabelDao: UserLabelDao
//        get() = applicationModule!!.mUserLabelDao
//
//    fun onCreate() {
//        //        if (BuildConfig.DEBUG) {
//        //            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//        //                    .detectDiskReads()
//        //                    .detectDiskWrites()
//        //                    .detectNetwork()   // or .detectAll() for all detectable problems
//        //                    .penaltyLog()
//        //                    .build());
//        //            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//        //                    .detectLeakedSqlLiteObjects()
//        //                    .detectLeakedClosableObjects()
//        //                    .penaltyLog()
//        //                    .penaltyDeath()
//        //                    .build());
//        //        }
//
//        super.onCreate()
//        //初始化服务器域名
//        DomainUtil.initDomain(this)
//        instance = this
//
//        FOpenLog.FLAG = BuildConfig.DEBUG
//
//        CookieSyncManager.createInstance(this)
//
//        initBaseHttps()
//
//        applicationModule = ApplicationModule(this)
//        applicationParam = ApplicationParam(this)
//
//        ///////////////////////////////////////////////////////////////////////////
//        // 6.3.1 管理Activity 堆栈
//        ///////////////////////////////////////////////////////////////////////////
//        ActivityStackManager.getInstance().init(this)
//
//        JZBReportSender.initSentry(this)
//        JZBReportSender.initCrashlytics(this)
//
//        //-6.3.2
//        jzbPopupDialog = JZBPopupDialog()
//
//        EventBus.builder().logNoSubscriberMessages(false)
//        EventBus.builder().logSubscriberExceptions(false)
//        EventManager.register(this)
//
//        ShareComponent.initShare()
//
//        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//        StrictMode.setThreadPolicy(policy)
//
//        DevelopUtil.initDevelopTools(this)
//
//        initTalUserManager(this)
//        initImageLoader(this)
//        //注册个推和阿里云推送通道
//        PushChannelHelper.INSTANCE.register(instance)
//    }
//
//    protected fun initTalUserManager(context: Context) {
//        talUnifiedLoginAuthedManager = TALUnifiedLoginAuthedManager(context, null)
//        talUnifiedLoginAuthedManager.registerImplicitAuthCallBack(object : ImplicitAuthCallBack() {
//            fun AuthSuccess(accessToken: String, openid: String) {
//                LoginThirdPartyComponent.LoginTalUserPresenter(BangApplication.instance)
//                        .handleTalUserCall(accessToken, openid)
//            }
//        })
//    }
//
//    protected fun attachBaseContext(base: Context) {
//        super.attachBaseContext(base)
//        MultiDex.install(this)
//        ACRA.init(this)
//    }
//
//    private fun initBaseHttps() {
//        try {
//            val logger = java.util.logging.Logger.getLogger(HttpURLConnection::class.java.name)
//            logger.level = Level.OFF
//
//            val ua = ActivityUtility.getUA(this)
//            BaseHttpClient.initBaseHttpClient(ua)
//            RestfulClient.initRestfulClient(ua)
//
//            HttpManager.init(this)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//    }
//
//    private fun shouldInit(): Boolean {
//        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//        val processInfos = am.runningAppProcesses
//        val mainProcessName = getPackageName()
//        val myPid = Process.myPid()
//        for (info in processInfos) {
//            if (info.pid == myPid && mainProcessName == info.processName) {
//                return true
//            }
//        }
//        return false
//    }
//
//    /**
//     * dp to px
//     *
//     * @param dpValue
//     * @return
//     */
//    fun dip2px(dpValue: Float): Int {
//        val scale = getResources().getDisplayMetrics().density
//        return (dpValue * scale + 0.5f).toInt()
//    }
//
//    fun updatePageViewCount() {
//        applicationModule!!.mAppSettings.updatePageViewCountCurrentVersion()
//    }
//
//    fun goActivity(act: Activity, cls: Class<*>) {
//        val intent = Intent(act, cls)
//        act.startActivity(intent)
//    }
//
//    fun goActivity(act: Activity, cls: Class<*>, bundle: Bundle) {
//        val intent = Intent(act, cls)
//        intent.putExtras(bundle)
//        act.startActivity(intent)
//    }
//
//    fun goActivity(act: Activity, cls: Class<*>, key: String, ser: Serializable) {
//        val intent = Intent(act, cls)
//        intent.putExtra(key, ser)
//        act.startActivity(intent)
//    }
//
//    @Subscribe
//    fun onEvent(event: RequestUpgradeEvent) {
//        FCloseLog.d("request upgrade event....")
//        AppUpgrade.getInstance(this).getUpgrade(true)
//    }
//
//    @Subscribe
//    fun onEvent(event: ThreadPublishEvent) {
//        FCloseLog.d("thread publish event....")
//
//        val threadPublisher = ThreadPublisher(this, event.draft, event.needJump, event.needJoin)
//        threadPublisher.startPost()
//    }
//
//    @Subscribe
//    fun onEvent(event: PushEvent) {
//        if (event.getType() === PushEvent.PushEventType.ORDER_VERIFY_START) {
//            val bundle = event.getBundle()
//            if (bundle.getBoolean("update")) {
//                applicationModule!!.payOrderManager.groupOrder2confirm(bundle.getString("orderId"))
//            }
//            applicationModule!!.payOrderManager.getGroupOrderStatus(bundle.getString("orderId"))
//        }
//    }
//
//    fun onTerminate() {
//        super.onTerminate()
//
//        AppStartManager.getInstance(this).onAppExit()
//        EventBus.getDefault().unregister(this)
//        applicationModule!!.mDraftStorage.close()
//        applicationModule!!.mOffLineChatMessageDao.clear()
//        applicationModule!!.mOffLinePrivateMessageDao.clear()
//    }
//
//    fun onAppActivityChanged(isActived: Boolean) {
//
//    }
//
//    /**
//     * 用户身份，学段的插码
//     */
//    fun setGAGrade() {
//        val appSettings = BangApplication.instance!!.appSettings
//        val userInfo = appSettings.getUser()
//        val grade = userInfo.grade
//        if (TextUtils.isEmpty(grade)) {
//            appSettings.markUserGradeSend(userInfo.uid, false)
//        } else {
//            defaultTracker.send(HitBuilders.ScreenViewBuilder().setCustomDimension(3, grade).build())
//            appSettings.markUserGradeSend(userInfo.uid, true)
//        }
//    }
//
//    fun onTrimMemory(level: Int) {
//        super.onTrimMemory(level)
//        ActivityStackManager.getInstance().onTrimMemory(level)
//    }
//
//    class RequestUpgradeEvent(var activity: Activity)
//
//    class ThreadPublishEvent @JvmOverloads constructor(var draft: ThreadDraft, var needJump: Boolean = false, var needJoin: Boolean = false)
//
//    companion object {
//
//
//        var THREAD_ID_NO_LOGIN_NOTIFICATION: Long = 0
//        var KNOWLEDGE_URL_TITLE_NO_LOGIN_NOTIFICATION = ""
//        var BROWSER_URL_TITLE_NOT_LOGIN_NOTIFICATION = ""
//        var IS_FROM_SEE_USER = false
//        var IS_FROM_MY_BANG = false
//        var IS_FROM_MIME = false
//        var mApi: IWXAPI? = null
//        var instance: BangApplication? = null
//            private set
//
//        val wxApi: IWXAPI
//            get() {
//                if (mApi == null) {
//                    mApi = WXAPIFactory.createWXAPI(getApplication(), Constant.WEIXIN_APP_ID, false)
//                    mApi!!.registerApp(Constant.WEIXIN_APP_ID)
//                }
//                return mApi
//            }
//
//        fun initFromMyBangAndFromMime() {
//            IS_FROM_MY_BANG = false
//            IS_FROM_MIME = false
//        }
//    }
}





