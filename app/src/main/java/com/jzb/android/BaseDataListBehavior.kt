package com.jzb.android

import com.jzb.android.recyclerview.IDataListBehavior

/**
 * Created by WikiPeng on 2017/3/9 18:33.
 */
abstract class BaseDataListBehavior : IDataListBehavior {

//    /**
//     * 是否截断处理显示错误信息
//     */
//    val isInterceptShowErrorMessage: Boolean
//        get() = false
//
//
//    /**
//     * 是否截断处理没有更多数据
//     */
//    val isInterceptNoMoreMessage: Boolean
//        get() = false
//
//
//    val isEmpty: Boolean
//        get() = false
//
//
//    //    /**
//    //     * 处理错误信息
//    //     */
//    //    @Override
//    //    public boolean handleErrorMessage(String defaultErrorMessage, boolean isIntercept);
//
//    fun handleErrorMessage(defaultErrorMessage: String, isIntercept: Boolean, errorCode: Int, errorMessage: String): Boolean {
//        var defaultErrorMessage = defaultErrorMessage
//        if (errorCode != 0) {
//            if (!TextUtils.isEmpty(errorMessage)) {
//                defaultErrorMessage = errorMessage
//            }
//
//            if (!isIntercept) {
//                Toast.makeText(BangApplication.getInstance(), defaultErrorMessage, Toast.LENGTH_SHORT).show()
//            }
//            return true
//        } else {
//            return false
//        }
//    }
//
//    /**
//     * 处理错误信息
//     */
//    @JvmOverloads
//    fun handleErrorMessage(errorMessage: String = BangApplication.getInstance().getString(R.string.tips_error_server)): Boolean {
//        return handleErrorMessage(errorMessage, isInterceptShowErrorMessage)
//    }
//
//    @JvmOverloads
//    fun handleEmptyMessage(isLoadMore: Boolean, errorMessage: String = BangApplication.getInstance()
//            .getString(R.string.tips_no_more_message)): Boolean {
//        if (isEmpty) {
//            if (isLoadMore && !isInterceptNoMoreMessage) {
//                Toast.makeText(BangApplication.getInstance(), errorMessage, Toast.LENGTH_SHORT).show()
//            }
//            return true
//        }
//
//        return false
//    }
//
//    fun hasMore(): Boolean {
//        return false
//    }
//
//    fun <T> add(data: T): Boolean {
//        return false
//    }
}
