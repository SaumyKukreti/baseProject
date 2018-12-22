package com.saumy.mvvmtestproject.models;

/**
 * Created by saumy on 12/22/2018.
 */

public class SubLocation {

    private String subLocationName;
    private String subLocationId;
    private String locationId;

    public SubLocation(String subLocationName, String subLocationId, String locationId) {
        this.subLocationName = subLocationName;
        this.subLocationId = subLocationId;
        this.locationId = locationId;
    }

    public String getSubLocationName() {
        return subLocationName;
    }

    public void setSubLocationName(String subLocationName) {
        this.subLocationName = subLocationName;
    }

    public String getSubLocationId() {
        return subLocationId;
    }

    public void setSubLocationId(String subLocationId) {
        this.subLocationId = subLocationId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return subLocationName;
    }
}
