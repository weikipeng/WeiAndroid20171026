package com.jzb.android.util.rx


import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 处理Rx线程
 * Created by YoKey.
 */
object JZBSchedulersHelper {

    val ioSchedulersTransformer: ObservableTransformer<*, *> = ObservableTransformer<Observable<*>, Observable<*>> { upstream ->
        upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
    }
    val mainSchedulersTransformer: ObservableTransformer<*, *> = ObservableTransformer<Observable<*>, Observable<*>> { upstream ->
        upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun <T> applyMainSchedulers(): ObservableTransformer<T, T> {
        return mainSchedulersTransformer as ObservableTransformer<T, T>
    }

    fun <T> applyIOSchedulers(): ObservableTransformer<T, T> {
        return ioSchedulersTransformer as ObservableTransformer<T, T>
    }
}