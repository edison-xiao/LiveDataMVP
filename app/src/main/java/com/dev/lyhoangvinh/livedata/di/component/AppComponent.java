package com.dev.lyhoangvinh.livedata.di.component;


import android.content.Context;

import com.dev.lyhoangvinh.livedata.MyApplication;
import com.dev.lyhoangvinh.livedata.data.RealmDatabase;
import com.dev.lyhoangvinh.livedata.di.module.AppModule;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules =
        AppModule.class)
public interface AppComponent {
    @ApplicationContext
    Context context();
    void inject(MyApplication application);
}
