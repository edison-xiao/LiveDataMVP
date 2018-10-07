package com.dev.lyhoangvinh.livedata.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayout();

    public abstract void initialize(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initialize(savedInstanceState);
    }

    public void addFragment(@IdRes int res, Fragment fragment, @Nullable String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(res, fragment, tag)
                .commit();
    }

    protected void finishWithAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }
}
