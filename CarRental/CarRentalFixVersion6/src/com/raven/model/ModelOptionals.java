package com.raven.model;

import javax.swing.Icon;

public class ModelOptionals {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public ModelOptionals(String title, String description, Icon icon, float cost) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.cost = cost;
    }

    public ModelOptionals() {
    }

    private String title;
    private String description;
    private float cost;
    private Icon icon;
}
