package com.raven.model;

public class ModelDetails {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ModelDetails(String title, String date, String location) {
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public ModelDetails() {
    }

    private String title;
    private String date;
    private String location;
}
