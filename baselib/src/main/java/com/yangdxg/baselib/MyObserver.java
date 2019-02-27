package com.yangdxg.baselib;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 作者： yangdongxing
 * 日期： 2019/2/26.
 * 功能：
 */

public class MyObserver<T> implements Observer<T> {

    private static final String TAG = "MyObserver";
    private final Context mContext;
    private final ObserverOnNextLisenter mLisenter;

    public MyObserver(Context context, ObserverOnNextLisenter lisenter) {
        mContext = context;
        mLisenter = lisenter;
    }


    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: "+e.toString() );
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: " );
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        Log.e(TAG, "onNext: "+t.toString() );
        mLisenter.onNext(t);
    }
}
