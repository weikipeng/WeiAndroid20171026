package com.jzb.android.classroom.mvp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.eduu.bang.R
import com.jzb.android.mvp.BPageRecyclerPresenter
import com.jzb.android.mvp.BaseMvpViewK
import com.jzb.android.mvp.IMvpViewK
import com.jzb.android.mvp.ViewDataK

interface IClassroomPresenter {

}

interface IClassroomMvpView {

}

/**
 * Created by wikipeng on 2017/11/2.
 */
class ClassroomMvpView : BaseMvpViewK, IClassroomMvpView {
    lateinit var mAppDelegate: AppCompatDelegate

    constructor(mAppDelegate: AppCompatDelegate) {
        this.mAppDelegate = mAppDelegate
        initView()
    }

    override fun initView() {
        if (mAppDelegate != null) {
            mAppDelegate.setContentView(R.layout.activity_classroom)
        }
    }

    override fun addEvent() {

    }

    override fun render(viewData: ViewDataK) {

    }
}

/**
 * Created by wikipeng on 2017/11/2.
 */
class ClassroomPresenter : BPageRecyclerPresenter, IClassroomPresenter {
    lateinit var mMvpView: IMvpViewK
    lateinit var mAppDelegate: AppCompatDelegate
    lateinit var mViewData: ViewDataK

    constructor(activity: Activity) {
        if (activity is AppCompatActivity) {
            mAppDelegate = activity.delegate
        }
        initData()
    }

    fun initData() {
        mMvpView = ClassroomMvpView(mAppDelegate)
    }


    override fun refresh(isForce: Boolean) {

    }

    private fun refreshAdList(isRefresh: Boolean) {
//        if (hasMoreAd) {
//            markFlag(true, FLAG_LOADING_TOP_NEWS_AD)
//            //            /*FOpenLog.e("jzbFocus debug mLoadingFlag:" + Integer.toBinaryString(mLoadingFlag));*/
//            //            DevLogTool.getInstance(BangApplication.getInstance())
//            //                    .saveLog("  有更多广告 ----------------开始请求广告========= adPageIndex：" + adPageIndex);
//            viewDataTopNewsList.setAdReady(false)
//            topNewsInteractor.getAdList(adPageIndex, IConstantParameters.PAGE_SIZE).subscribe(object : JZBSubscriber<STopNewsAdRes>() {
//                fun onError(e: Throwable) {
//                    super.onError(e)
//                    viewDataTopNewsList.setAdReady(true)
//                    markFlag(false, FLAG_LOADING_TOP_NEWS_AD)
//                    //                    /*FOpenLog.e("jzbFocus debug mLoadingFlag:" + Integer.toBinaryString(mLoadingFlag));*/
//                }
//
//                fun onNext(@NonNull result: STopNewsAdRes) {
//                    //                    /*FOpenLog.e("jzbFocus debug mLoadingFlag:" + Integer.toBinaryString(mLoadingFlag));*/
//                    handleAdResult(result)
//                    adPageIndex++
//                    //重置加载中标记位
//                    markFlag(false, FLAG_LOADING_TOP_NEWS_AD)
//                }
//            })
//        } else {
//            //            DevLogTool.getInstance(BangApplication.getInstance())
//            //                    .saveLog("  没有有更多广告 ----------------mLoadingFlag：" + Integer.toBinaryString(mLoadingFlag));
//            viewDataTopNewsList.setAdReady(true)
//        }
    }
}