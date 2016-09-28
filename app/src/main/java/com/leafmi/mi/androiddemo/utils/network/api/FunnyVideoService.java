package com.leafmi.mi.androiddemo.utils.network.api;

import com.leafmi.mi.androiddemo.bean.network.FunVideo;

import java.util.List;

import retrofit.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;

/**
 * Created by Admin on 2016/9/28.
 */
public interface FunnyVideoService {
    @GET("v1/data/搞笑视频/{page}/{size}")
    Call<List<FunVideo>> getFunnyVideoCall(
            @Path("page") String page,
            @Path("size") String size);
}
