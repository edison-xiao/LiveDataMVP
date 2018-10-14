package com.dev.lyhoangvinh.livedata.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Collections {

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

    public String getTitle() {
        return title;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public Integer getTotalViews() {
        return totalViews;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public String getCollectionUrl() {
        return collectionUrl;
    }
}
