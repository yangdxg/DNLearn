package com.yangdxg.dnlearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yangdxg.baselib.ApiService;
import com.yangdxg.baselib.Move;
import com.yangdxg.baselib.MyObserver;
import com.yangdxg.baselib.ObserverOnNextLisenter;
import com.yangdxg.baselib.ProgressObserver;
import com.yangdxg.baselib.RetrofitManager;
import com.yangdxg.baselib.RxRetrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxRetrofit.getTopMovie(new ProgressObserver<Move>(this, new ObserverOnNextLisenter<Move>() {
            @Override
            public void onNext(Move move) {
                Log.e(TAG, "onNext: "+move.toString() );
            }

        }),1,10);
    }
}
