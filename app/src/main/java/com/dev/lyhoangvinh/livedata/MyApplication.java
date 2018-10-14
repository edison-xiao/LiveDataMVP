package com.dev.lyhoangvinh.livedata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;

import io.realm.Realm;


public class MyApplication extends Application {

    private Gson mGSon;

    private static MyApplication mSelf;

    public static MyApplication self() {
        return mSelf;
    }

    private static Realm realm;

    public static Realm getRealm() {
        if (realm == null){
            realm = Realm.getDefaultInstance();
        }
        return realm;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        mGSon = new Gson();
        Realm.init(this);
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

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public Gson getGSon() {
        return mGSon;
    }


}

