package com.dev.lyhoangvinh.livedata.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsResponse {

    @SerializedName("has_more")
    @Expose
    private boolean hasMore;
    @SerializedName("total_collections")
    @Expose
    private int totalCollections;
    @SerializedName("current_offset")
    @Expose
    private int currentOffset;
    @SerializedName("limit")
    @Expose
    private int limit;

    @SerializedName("collections")
    @Expose
    private List<Collections> collections;

    public boolean isHasMore() {
        return hasMore;
    }

    public int getTotalCollections() {
        return totalCollections;
    }

    public int getCurrentOffset() {
        return currentOffset;
    }

    public int getLimit() {
        return limit;
    }

    public List<Collections> getCollections() {
        return collections;
    }
}
