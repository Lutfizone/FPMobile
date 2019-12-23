package com.lutfizone.moviesion.api;

import com.lutfizone.moviesion.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {
    private static Retrofit getRetroClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static ClientService getServiceRetrofit() {
        return getRetroClient().create(ClientService.class);
    }
}

