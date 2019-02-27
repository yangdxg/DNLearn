package com.yangdxg.baselib;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/26.
 * 功能：
 */

public class RxRetrofit {

    /**
     * 封装线程管理和订阅
     * @param observable
     * @param observer
     */
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTopMovie(Observer<Move> observer,int start,int count){
        ApiSubscribe(RetrofitManager.getApiService().getMoveTop250(start,count),observer);
    }

}
