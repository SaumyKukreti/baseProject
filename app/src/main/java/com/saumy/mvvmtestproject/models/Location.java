package com.saumy.mvvmtestproject.models;

import java.util.List;

/**
 * Created by saumy on 12/22/2018.
 */

public class Location {

    private String locationName;
    private String locationId;
    private List<SubLocation> sbLocationList;

    public Location(String locationName, String locationId) {
        this.locationName = locationName;
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public List<SubLocation> getSbLocationList() {
        return sbLocationList;
    }

    public void setSbLocationList(List<SubLocation> sbLocationList) {
        this.sbLocationList = sbLocationList;
    }
}
