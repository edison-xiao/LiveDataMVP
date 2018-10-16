package com.dev.lyhoangvinh.livedata.di.module;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.dev.lyhoangvinh.livedata.base.fragment.BaseFragment;
import com.dev.lyhoangvinh.livedata.di.qualifier.ChildFragmentManager;
import com.dev.lyhoangvinh.livedata.di.scopes.PerFragment;

import dagger.Module;
import dagger.Provides;


@Module
public class FragmentModule {

    private final BaseFragment mFragment;

    public FragmentModule(BaseFragment fragment) {
        mFragment = fragment;
    }

    @PerFragment
    @Provides
    Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @PerFragment
    @ChildFragmentManager
    FragmentManager provideChildFragmentManager() { return mFragment.getChildFragmentManager(); }


    @Provides
    FragmentActivity provideActivity() {
        return mFragment.getActivity();
    }

}
