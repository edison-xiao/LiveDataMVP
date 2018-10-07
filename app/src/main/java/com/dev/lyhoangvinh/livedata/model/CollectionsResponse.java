package com.dev.lyhoangvinh.livedata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
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
}
