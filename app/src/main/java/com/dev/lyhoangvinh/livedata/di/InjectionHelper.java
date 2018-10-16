package com.dev.lyhoangvinh.livedata.di;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.dev.lyhoangvinh.livedata.MyApplication;
import com.dev.lyhoangvinh.livedata.di.component.AppComponent;


public class InjectionHelper {

    public static AppComponent getAppComponent(Context context) {
        return MyApplication.get(context).getAppComponent();
    }
    public static AppComponent getAppComponent(Fragment fragment) {
        return getAppComponent(fragment.getActivity());
    }

    public static AppComponent getAppComponent(Activity activity) {
        return MyApplication.get(activity).getAppComponent();
    }
}
