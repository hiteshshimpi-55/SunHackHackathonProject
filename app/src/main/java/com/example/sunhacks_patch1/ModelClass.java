package com.example.sunhacks_patch1;

import java.io.Serializable;

public class ModelClass implements Serializable {
    String name,About,threeDModel_link,Title;
    String imageUrl;
    double latitude,longitude;



    public ModelClass(String name, String about, String threeDModel_link, String title, double latitude, double longitude) {
        this.name = name;
        About = about;
        this.threeDModel_link = threeDModel_link;
        Title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getThreeDModel_link() {
        return threeDModel_link;
    }

    public void setThreeDModel_link(String threeDModel_link) {
        this.threeDModel_link = threeDModel_link;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
}
