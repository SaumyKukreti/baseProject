package com.saumy.mvvmtestproject.models;

/**
 * Created by saumy on 2/25/2019.
 */

public class Bag {
    private String id;
    private String bagTag;
    private String fallbackTag;
    private String status;

    public Bag(String id, String bagTag, String fallbackTag, String status) {
        super();
        this.id = id;
        this.bagTag = bagTag;
        this.fallbackTag = fallbackTag;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBagTag() {
        return bagTag;
    }
    public void setBagTag(String bagTag) {
        this.bagTag = bagTag;
    }
    public String getFallbackTag() {
        return fallbackTag;
    }
    public void setFallbackTag(String fallbackTag) {
        this.fallbackTag = fallbackTag;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}
