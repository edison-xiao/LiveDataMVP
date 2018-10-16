package com.dev.lyhoangvinh.livedata.base.api;

import com.dev.lyhoangvinh.livedata.base.response.BaseResponse;
import com.dev.lyhoangvinh.livedata.data.model.CollectionsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("collections/{page}")
    Single<BaseResponse<CollectionsResponse>> getCollections(@Path("page") int page);
}
