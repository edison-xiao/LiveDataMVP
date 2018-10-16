package com.dev.lyhoangvinh.livedata.di.module;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.dev.lyhoangvinh.livedata.base.activity.BaseActivity;
import com.dev.lyhoangvinh.livedata.di.qualifier.ActivityContext;
import com.dev.lyhoangvinh.livedata.di.qualifier.ActivityFragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    protected FragmentActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    protected Context provideContext() {
        return mActivity;
    }

    @Provides
    @ActivityFragmentManager
    protected FragmentManager provideFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }


//    @Provides
//    protected LifecycleOwner provideLifeCycleOwner() {
//        return mActivity;
//    }
}