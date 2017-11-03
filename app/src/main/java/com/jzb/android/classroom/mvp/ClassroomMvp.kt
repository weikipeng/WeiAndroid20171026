package com.jzb.android.classroom.mvp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.eduu.bang.R
import com.jzb.android.classroom.interactor.TopNewsInteractorImpl
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
    val mTopNewsInteractor = TopNewsInteractorImpl()


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
        refreshAdList(true)
    }

    private fun refreshAdList(isRefresh: Boolean) {
    }
}