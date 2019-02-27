package com.yangdxg.baselib;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/21.
 * 功能：
 */

public interface ApiService {


    /**
     * 一般方法返回值是Retrofit2.Call,使用RxJava的化返回Observable
     * Retrofit2.Call比Okhttp.Call增加了更多信息
     */

    @GET("users/{user}/repos")
    Call<List<String>> listRepos(@Path("user") String user);

    @GET("users/{user}/repos")
    Observable<List<String>> listReposObservable(@Path("user") String user);

    @GET("v2/movie/top250")
    Observable<Move> getMoveTop250(@Query("start") int start, @Query("count") int count);
}
