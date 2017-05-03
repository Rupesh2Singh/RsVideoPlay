package com.rupesh.rsvideoplay.rest;


import com.rupesh.rsvideoplay.util.VideoList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rupesh on 4/25/2017.
 */
@SuppressWarnings("ALL")
public interface ApiInterface {

    @FormUrlEncoded
    @POST("viral_event_videos.php")
    Call<VideoList> getVideoList(@Field("user_id") String driver_id);

}
