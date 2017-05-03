package com.rupesh.rsvideoplay.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rupesh on 4/25/2017.
 */
@SuppressWarnings("ALL")
public class ApiClient {

    private static final String BASE_URL = "http://viraltube.co.in/moneytree-test/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
