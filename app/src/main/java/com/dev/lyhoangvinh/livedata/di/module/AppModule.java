package com.dev.lyhoangvinh.livedata.di.module;

import android.app.Application;
import android.content.Context;

import com.dev.lyhoangvinh.livedata.base.api.ServiceFactory;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    protected Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return ServiceFactory.makeGsonForRealm();
    }
}