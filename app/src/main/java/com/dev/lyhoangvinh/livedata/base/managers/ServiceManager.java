package com.dev.lyhoangvinh.livedata.base.managers;

import android.content.Context;
import android.support.annotation.NonNull;

import com.dev.lyhoangvinh.livedata.base.api.ApiService;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServiceManager {

    protected Context mContext;
    protected ApiService apiService;

    @Inject
    public ServiceManager(@ApplicationContext Context mContext, ApiService apiService) {
        this.mContext = mContext;
        this.apiService = apiService;
    }

    @NonNull
    public ApiService getApiService() {
        return apiService;
    }
}
