package com.dev.lyhoangvinh.livedata.base.interfaces;

import android.os.Bundle;


public interface Lifecycle extends Destroyable{
    void onCreate();
    void onStart();
    void onStop();
    void onSaveInstanceState(Bundle outState);
    void onRestoreInstanceState(Bundle savedInstanceState);
}
