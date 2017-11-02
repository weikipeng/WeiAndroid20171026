package com.jzb.android.recyclerview

/**
 * Created by WikiPeng on 2017/3/9 18:26.
 */
interface IDataListBehavior {
    /**
     * 数据是否为空
     */
    val isEmpty: Boolean

    val isInterceptShowErrorMessage: Boolean

    val isInterceptNoMoreMessage: Boolean
    /**
     * 是否还有更多数据
     */
    fun hasMore(): Boolean

    /**
     * 处理错误信息
     */
    fun handleErrorMessage(): Boolean

    fun handleErrorMessage(errorMessage: String): Boolean

    fun handleErrorMessage(defaultErrorMessage: String, isIntercept: Boolean): Boolean

    fun handleEmptyMessage(isLoadMore: Boolean, errorMessage: String): Boolean

    fun handleEmptyMessage(isLoadMore: Boolean): Boolean

    fun <T> add(data: T): Boolean
}