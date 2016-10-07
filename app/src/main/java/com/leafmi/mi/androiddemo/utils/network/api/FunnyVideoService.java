package com.leafmi.mi.androiddemo.utils.network.api;

import com.leafmi.mi.androiddemo.bean.network.FunVideo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Admin on 2016/9/28.
 */
public interface FunnyVideoService {
    @GET("v1/data/搞笑视频/{page}/{size}")
    Observable<FunVideo> getFunnyVideoCall(
            @Path("page") int page,
            @Path("size") int size);
}
