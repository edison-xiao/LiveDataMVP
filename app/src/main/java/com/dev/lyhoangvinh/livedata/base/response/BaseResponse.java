package com.dev.lyhoangvinh.livedata.base.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("response")
    @Expose
    private T response;

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }
}

