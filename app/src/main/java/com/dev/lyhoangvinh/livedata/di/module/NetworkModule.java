package com.dev.lyhoangvinh.livedata.di.module;


import android.content.Context;

import com.dev.lyhoangvinh.livedata.base.api.ApiService;
import com.dev.lyhoangvinh.livedata.base.api.ServiceFactory;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;
import com.dev.lyhoangvinh.livedata.di.qualifier.OkHttpNoAuth;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {

    protected Context context;

    public NetworkModule(@ApplicationContext Context context) {
        this.context = context;
    }

    @Provides
    @OkHttpNoAuth
    @Singleton
    static OkHttpClient provideOkHttpClientNoAuth(@ApplicationContext Context context) {
        return ServiceFactory.makeOkHttpClientBuilder(context).build();
    }


    @Provides
    @Singleton
    static ApiService provideApiService(Gson gson, @OkHttpNoAuth OkHttpClient okHttpClient) {
        return ServiceFactory.makeService(ApiService.class, gson, okHttpClient);
    }
}
