package com.yangdxg.baselib;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能：
 */

public class RetrofitManager {

    String baseUrl = "https://api.douban.com/";
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 7676;
    private static RetrofitManager mInstance;
    private Retrofit mRetrofit;
    private  ApiService mApiService;

    public RetrofitManager() {
        init();
    }

    public static RetrofitManager getInstance(){
        if (mInstance==null){
            synchronized (RetrofitManager.class){
                if (mInstance==null){
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    public void init() {
        //初始化okhttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS);
        builder.connectTimeout(CONNECT_TIME_OUT,TimeUnit.MILLISECONDS);
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logger);
        OkHttpClient client = builder.build();
        //初始化Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public static ApiService getApiService(){
        return getInstance().mApiService;
    }

}
