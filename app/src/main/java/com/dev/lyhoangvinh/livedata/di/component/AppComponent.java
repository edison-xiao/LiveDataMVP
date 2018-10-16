package com.dev.lyhoangvinh.livedata.di.component;


import com.dev.lyhoangvinh.livedata.MyApplication;
import com.dev.lyhoangvinh.livedata.data.RealmDatabase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppComponent {

    void inject(MyApplication application);
}
