package com.jzb.android.classroom.interactor

import com.jzb.android.pojo.STopNewsAdRes
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wikipeng on 2017/11/3.
 */
interface TopNewsInteractor {
    /**
     * 6.5获取首页头条广告
     */
    abstract fun getAdList(pageIndex: Int, pageSize: Int): Observable<STopNewsAdRes>?
}

class TopNewsInteractorImpl : TopNewsInteractor {
    override fun getAdList(pageIndex: Int, pageSize: Int): Observable<STopNewsAdRes>? {
        return null
    }
//    internal var topNewsRemoteApi = BaseInteractor.createRestService(TopNewsRemoteInterface::class.java)

//    override fun getAdList(pageIndex: Int, pageSize: Int): Observable<STopNewsAdRes> {
//        return topNewsRemoteApi.getAdList(pageIndex * pageSize, pageSize)
//                .compose(JZBSchedulersHelper.applyIOSchedulers())
//                .map(object : Function<STopNewsAdRes, STopNewsAdRes> {
//                    @Throws(Exception::class)
//                    override fun apply(@NonNull sTopNewsAdRes: STopNewsAdRes?): STopNewsAdRes? {
//                        if (sTopNewsAdRes != null && sTopNewsAdRes.adList != null) {
//                            Collections.sort(sTopNewsAdRes.adList, Comparator<STopNewsAd> { o1, o2 ->
//                                if (o1 == o2) {
//                                    return@Comparator 0
//                                }
//                                if (o1 == null) {
//                                    return@Comparator -1
//                                }
//
//                                if (o2 == null) {
//                                    return@Comparator 1
//                                }
//
//                                if (o1.pos === o2!!.pos) {
//                                    return@Comparator if (o1.id < o2.id) -1 else 1
//                                }
//
//                                if (o1.pos < o2.pos) -1 else 1
//                            })
//                        }
//                        return sTopNewsAdRes
//                    }
//                }).compose(JZBSchedulersHelper.applyMainSchedulers())
//    }
}

interface TopNewsRemoteInterface {
    @GET("advertising/topad/")
    abstract fun getAdList(@Query("offset") offset: Int, @Query("limit") pageSize: Int): Observable<STopNewsAdRes>
}