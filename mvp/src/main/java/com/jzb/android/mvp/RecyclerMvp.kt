package com.jzb.android.mvp

import android.support.v7.widget.RecyclerView

/**
 * Created by wikipeng on 2017/11/2.
 */
interface IRecyclerPresenterK : IPresenterK {

}

abstract class BPageRecycleMvpView : BPageMvpViewK() {
    var mRecyclerView: RecyclerView? = null

    override fun initView() {
        super.initView()
        if (mRootView != null) {
            mRecyclerView = mRootView.findViewById(R.id.recyclerView)
        }
    }
}

abstract class BPageRecyclerPresenter : IRecyclerPresenterK {
    var mAdapter: RecyclerView.Adapter<*>? = null
}