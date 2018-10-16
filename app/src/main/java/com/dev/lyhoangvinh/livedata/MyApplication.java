package com.dev.lyhoangvinh.livedata;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.dev.lyhoangvinh.livedata.di.component.AppComponent;
import com.dev.lyhoangvinh.livedata.di.component.DaggerAppComponent;
import com.dev.lyhoangvinh.livedata.di.module.AppModule;

public class MyApplication extends Application {

    protected AppComponent appComponent;

    // component
    protected void setupAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            setupAppComponent();
        }
        return appComponent;
    }


    public static MyApplication get(Activity activity) {
        return (MyApplication)activity.getApplication();
    }

    public static MyApplication get(Fragment fragment) {
        return get(fragment.getActivity());
    }

    public static MyApplication get(Context context) {
        return (MyApplication)context.getApplicationContext();
    }

}

