package com.dev.lyhoangvinh.livedata.di.module;

import android.content.Context;

import com.dev.lyhoangvinh.livedata.base.api.ApiService;
import com.dev.lyhoangvinh.livedata.base.managers.ServiceManager;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {
    private final Context mContext;

    public ServiceModule(@ApplicationContext Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    ServiceManager provideServiceManager(@ApplicationContext Context context, ApiService apiService){
       return new ServiceManager(context, apiService);
    }
}
