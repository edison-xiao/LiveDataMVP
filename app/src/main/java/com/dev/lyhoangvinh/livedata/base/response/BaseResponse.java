package com.dev.lyhoangvinh.livedata.base.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class BaseResponse<T> {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("response")
    @Expose
    private T response;
}
