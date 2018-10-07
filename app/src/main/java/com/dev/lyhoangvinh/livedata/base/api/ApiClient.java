package com.dev.lyhoangvinh.livedata.base.api;

import com.dev.lyhoangvinh.livedata.BuildConfig;
import com.dev.lyhoangvinh.livedata.constants.ConstantsApi;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static <T> T makeService(Class<T> serviceClass) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        // timeout
        okHttpClient.readTimeout(60, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS);
        // logging
        okHttpClient.addInterceptor(BuildConfig.DEBUG
                ? new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                : new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsApi.BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        return retrofit.create(serviceClass);
    }
}
