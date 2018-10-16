package com.dev.lyhoangvinh.livedata;


import android.app.Activity;
import android.app.Application;

import com.dev.lyhoangvinh.livedata.di.component.AppComponent;
import com.dev.lyhoangvinh.livedata.di.component.DaggerAppComponent;

public class MyApplication extends Application {

    protected AppComponent appComponent;

    // component
    protected void setupAppComponent() {
        appComponent = DaggerAppComponent.builder()
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

}

