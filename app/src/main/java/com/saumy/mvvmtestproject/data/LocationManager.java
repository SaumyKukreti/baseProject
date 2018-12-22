package com.saumy.mvvmtestproject.data;

import com.saumy.mvvmtestproject.models.Location;
import com.saumy.mvvmtestproject.models.SubLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saumy on 12/22/2018.
 */

public class LocationManager {

    /**
     * This method is used to return a list of sub locations
     */
    public static List<Location> getListOfLocation(){

        List<Location> listOfLocation = new ArrayList<>();
        listOfLocation.add(getLocationOne());
        listOfLocation.add(getLocationTwo());

        return listOfLocation;
    }

    /**
     * This method is used to create one location
     * @return
     */
    private static Location getLocationOne() {

        Location location = new Location("Panchkula","Panchkula");

        List<SubLocation> subLocationList = new ArrayList<>();
        subLocationList.add(new SubLocation("ManiMajra", "1", "Panchkula"));
        subLocationList.add(new SubLocation("MDC4", "2", "Panchkula"));
        subLocationList.add(new SubLocation("MDC5", "3", "Panchkula"));
        subLocationList.add(new SubLocation("MDC6", "4", "Panchkula"));


        location.setSbLocationList(subLocationList);
        return location;
    }

    private static Location getLocationTwo() {
        Location location = new Location("Chandigarh","Chandigarh");

        List<SubLocation> subLocationList = new ArrayList<>();
        subLocationList.add(new SubLocation("Sector 26", "1", "Chandigarh"));
        subLocationList.add(new SubLocation("Sector 24", "2", "Chandigarh"));
        subLocationList.add(new SubLocation("Sector 23", "3", "Chandigarh"));
        subLocationList.add(new SubLocation("Sector 22", "4", "Chandigarh"));

        location.setSbLocationList(subLocationList);
        return location;
    }

    public static List<String> getListOfLocationNames() {
        List<String> listOfLocationNames = new ArrayList<>();

        for(Location location : getListOfLocation()){
            listOfLocationNames.add(location.getLocationName());
        }

        return listOfLocationNames;
    }
}
