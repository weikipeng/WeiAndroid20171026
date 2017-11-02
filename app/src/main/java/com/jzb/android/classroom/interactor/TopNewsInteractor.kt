package com.jzb.android.classroom.interactor

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wikipeng on 2017/11/3.
 */
interface TopNewsInteractor {

}

interface TopNewsRemoteInterface{
    /**
     * @since 6.5
     */
    @GET("advertising/topad/")
    abstract fun getAdList(@Query("offset") offset: Int, @Query("limit") pageSize: Int): Observable<STopNewsAdRes>

}

class TopNewsInteractorImpl:TopNewsInteractor{
    /**
     * 6.5获取首页头条广告
     */
    abstract fun getAdList(pageIndex: Int, pageSize: Int): Observable<STopNewsAdRes>
}