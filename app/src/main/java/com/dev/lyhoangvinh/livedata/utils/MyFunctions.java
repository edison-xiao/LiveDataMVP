package com.dev.lyhoangvinh.livedata.utils;

import com.bumptech.glide.request.RequestOptions;
import com.dev.lyhoangvinh.livedata.R;


public class MyFunctions {
    public static RequestOptions getRequestOptions() {
        return new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);
    }
}
