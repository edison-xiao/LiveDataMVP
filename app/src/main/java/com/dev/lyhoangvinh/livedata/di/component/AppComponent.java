package com.dev.lyhoangvinh.livedata.di.component;


import android.content.Context;

import com.dev.lyhoangvinh.livedata.MyApplication;
import com.dev.lyhoangvinh.livedata.base.api.ApiService;
import com.dev.lyhoangvinh.livedata.base.managers.ServiceManager;
import com.dev.lyhoangvinh.livedata.data.RealmDatabase;
import com.dev.lyhoangvinh.livedata.di.module.AppModule;
import com.dev.lyhoangvinh.livedata.di.module.NetworkModule;
import com.dev.lyhoangvinh.livedata.di.module.ServiceModule;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        ServiceModule.class
})
public interface AppComponent {
    @ApplicationContext
    Context context();

    ApiService getApiService();

    RealmDatabase realmDatabase();

    ServiceManager getServiceManager();

    void inject(MyApplication application);
}
