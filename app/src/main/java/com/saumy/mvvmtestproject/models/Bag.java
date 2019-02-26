package com.saumy.mvvmtestproject.models;

/**
 * Created by saumy on 2/25/2019.
 */

public class Bag {
    private String id;
    private String bagTag;
    private String fallbackTag;
    private String firstName;
    private String lastName;
    private String status;

    public Bag(String id, String firstName, String lastName, String bagTag, String fallbackTag, String status) {
        super();
        this.id = id;
        this.bagTag = bagTag;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Id:"+this.getId()).append("\n");
        str.append("FirstName:"+this.getFirstName()).append("\n");
        str.append("LastName:"+this.getLastName()).append("\n");
        str.append("BagTag:"+this.getBagTag()).append("\n");
        str.append("Status:"+this.getStatus()).append("\n");
        str.append("Fallback Tag:"+this.getFallbackTag()).append("\n");
        return str.toString();
    }
}
