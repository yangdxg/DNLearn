package com.yangdxg.baselib;

import android.content.Context;
import android.util.Log;

import com.yangdxg.baselib.dialog.ProgressCancleLisenter;
import com.yangdxg.baselib.dialog.ProgressDialogHandler;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 作者： yangdongxing
 * 日期： 2019/2/26.
 * 功能：
 */

public class ProgressObserver<T> implements Observer<T>, ProgressCancleLisenter {

    private static final String TAG = "MyObserver";
    private final Context mContext;
    private final ObserverOnNextLisenter mLisenter;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable mD;

    public ProgressObserver(Context context, ObserverOnNextLisenter lisenter) {
        mContext = context;
        mLisenter = lisenter;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }


    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.toString());
        dismissProgressDialog();
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
        dismissProgressDialog();
    }

    @Override
    public void onSubscribe(Disposable d) {
        mD = d;
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        mLisenter.onNext(t);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onCancleProgress() {
        //如果处于订阅状态，则取消订阅
        if (!mD.isDisposed()){
            mD.dispose();
        }
    }
}
