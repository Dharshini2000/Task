package com.example.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;public String getBy() {
        return by;
    }public void setBy(String by) {
        this.by = by;
    }public Integer getId() {
        return id;
    }public void setId(Integer id) {
        this.id = id;
    }public String getTitle() {
        return title;
    }public void setTitle(String title) {
        this.title = title;
    }public String getUrl() {
        return url;
    }public void setUrl(String url) {
        this.url = url;
}}

