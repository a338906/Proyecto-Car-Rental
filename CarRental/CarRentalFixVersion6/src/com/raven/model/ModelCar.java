package com.raven.model;

import javax.swing.Icon;

public class ModelCar {        
    
    //CAR
    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String description) {
        this.typeCar = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }
    
    public float getPriceCounter() {
        return priceCounter;
    }

    public void setPriceCounter(float priceCounter) {
        this.priceCounter = priceCounter;
    }
    
    public float getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(float priceNow) {
        this.priceNow = priceNow;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public float getDifference() {
        return difference;
    }

    public void setDifference(float difference) {
        this.difference = difference;
    }

    
    //ABOUT
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    } 
    
    public Icon getSeatIcon() {
        return seatIcon;
    }

    public void setSeatIcon(Icon seatIcon) {
        this.seatIcon = seatIcon;
    }
    
    public int getSmall() {
        return small;
    }

    public void setSmall(int small) {
        this.small = small;
    } 
    
    public Icon getSmallIcon() {
        return smallIcon;
    }

    public void setgetSmallIcon(Icon smallIcon) {
        this.smallIcon = smallIcon;
    }
    
    
    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    } 
    
    public Icon getDoorIcon() {
        return doorIcon;
    }

    public void setDoorIcon(Icon doorIcon) {
        this.doorIcon = doorIcon;
    }
    
    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    } 
    
    public Icon getGasIcon() {
        return gasIcon;
    }

    public void setGasIcon(Icon gasIcon) {
        this.gasIcon = gasIcon;
    }
    
    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    } 
    
    public Icon getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(Icon largeIcon) {
        this.largeIcon = largeIcon;
    }
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    } 
    
    public Icon getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(Icon typeIcon) {
        this.typeIcon = typeIcon;
    }
    
    public Icon getCarIcon() {
        return car;
    }

    public void getCarIcon(Icon icon) {
        this.car = icon;
    }
    
    
    public ModelCar(Icon icon, String typeCar, String name, float priceCounter, float priceNow, 
            int seat, int small, int door, int gas, int large, String type,int amount, Icon seatIcon, Icon smallIcon, 
            Icon doorIcon, Icon gasIcon, Icon largeIcon, Icon typeIcon, float difference) {
        this.car = icon;
        this.typeCar = typeCar;
        this.name = name;
        this.priceCounter = priceCounter;
        this.priceNow = priceNow;
        this.amount = amount;
        this.difference = difference;
        
        this.seat = seat;
        this.small = small;
        this.door = door;
        this.gas = gas;
        this.large = large;
        this.type = type;
        
        this.seatIcon = seatIcon;
        this.smallIcon = smallIcon;
        this.doorIcon = doorIcon;
        this.gasIcon = gasIcon;
        this.largeIcon = largeIcon;
        this.typeIcon = typeIcon;
        
    }

    public ModelCar() {
    }

    private Icon car;
    private float priceCounter;
    private float priceNow;
    private String typeCar;
    private String name;
    private int amount;
    private float difference;
    
    private int seat;    
    private Icon seatIcon;
    private int small;    
    private Icon smallIcon;
    private int door;    
    private Icon doorIcon;
    private int gas;    
    private Icon gasIcon;
    private int large;    
    private Icon largeIcon;
    private String type;    
    private Icon typeIcon;
    
}
