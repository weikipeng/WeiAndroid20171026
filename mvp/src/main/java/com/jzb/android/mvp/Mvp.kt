package com.jzb.android.mvp

import android.view.View

/**
 * Created by wikipeng on 2017/11/2.
 */
interface IMvpViewK {
    fun render(viewData: ViewDataK)
}

interface IPresenterK {
    fun refresh(isForce: Boolean)
}

abstract class BaseMvpViewK : IMvpViewK {
    val mRootView: View? = null

    protected open fun initView() {

    }

    protected open fun initData() {

    }

    protected open fun addEvent() {

    }
}

abstract class BasePresenterK : IPresenterK {
}

class ViewDataK {
    var action: String? = null
    var data: Map<String, Any>? = null
}

//class ViewData {
//    var action: String? = null
//    var data: Map<String, Any>? = null
//}
