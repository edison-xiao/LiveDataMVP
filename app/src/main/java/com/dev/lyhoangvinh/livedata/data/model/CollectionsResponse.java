package com.dev.lyhoangvinh.livedata.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CollectionsResponse  {

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
    private List<Collectionss> collections;

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

    public List<Collectionss> getCollections() {
        return collections;
    }
}
