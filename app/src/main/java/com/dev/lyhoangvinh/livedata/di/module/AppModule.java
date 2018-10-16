package com.dev.lyhoangvinh.livedata.di.module;

import android.app.Application;
import android.content.Context;

import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;

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
}