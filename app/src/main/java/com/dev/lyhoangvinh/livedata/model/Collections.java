package com.dev.lyhoangvinh.livedata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Collections {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("cover_url")
    @Expose
    private String coverUrl;
    @SerializedName("total_views")
    @Expose
    private Integer totalViews;
    @SerializedName("video_count")
    @Expose
    private Integer videoCount;
    @SerializedName("collection_url")
    @Expose
    private String collectionUrl;
}
