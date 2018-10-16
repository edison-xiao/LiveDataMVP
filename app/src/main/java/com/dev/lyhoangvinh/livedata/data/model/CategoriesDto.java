package com.dev.lyhoangvinh.livedata.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CategoriesDto extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    Long id;

    @SerializedName("CHID")
    @Expose
    String cHID;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("slug")
    @Expose
    String slug;
    @SerializedName("total_videos")
    @Expose
    Integer totalVideos;
    @SerializedName("shortname")
    @Expose
    String shortname;
    @SerializedName("category_url")
    @Expose
    String categoryUrl;
    @SerializedName("cover_url")
    @Expose
    String coverUrl;
}
