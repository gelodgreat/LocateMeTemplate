package com.angelo.locateme.model;

/**
 * Created by crumali on 6/28/2017.
 */

public class Devslopes {

    private double latitude;
    private double longitude;
    private String locationTitle;
    private String locationAddress;
    private String locationImrUrl;

    final String DRAWABLE = "drawable/";

    public String getImgURL() {
        return DRAWABLE + locationImrUrl;
    }

    public Devslopes(double latitude, double longitude, String locationTitle, String locationAddress, String locationImrUrl) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationTitle = locationTitle;
        this.locationAddress = locationAddress;
        this.locationImrUrl = locationImrUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationImrUrl() {
        return locationImrUrl;
    }

    public void setLocationImrUrl(String locationImrUrl) {
        this.locationImrUrl = locationImrUrl;
    }
}
