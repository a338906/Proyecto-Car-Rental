package model.login;

import javax.swing.Icon;

public class ModelRegister {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastame() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail (String mail) {
        this.mail = mail;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getType() {
        return typecard;
    }

    public void setType(String typecard) {
        this.typecard = typecard;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth (String month) {
        this.month = month;
    }
    
    public String getYear() {
        return year;
    }

    public void setYear (String year) {
        this.year = year;
    }
    
    public String getCard() {
        return card;
    }

    public void setCard (String card) {
        this.card = card;
    }

    public String getState() {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }
    
    public String getDiscount() {
        return discount;
    }

    public void setDiscount (String discount) {
        this.discount = discount;
    }
    
    public ModelRegister(int userID, String name, String lastName, 
            String userName, int age, String mail, String address, 
            String postal, String phone, String typecard, String month, 
            String year, String card, String state, String discount) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.postal = postal;
        this.phone = phone;
        this.typecard = typecard;
        this.month = month;
        this.year = year;
        this.card = card;
        this.state = state;
        this.discount = discount;    
        
    }

    public ModelRegister() {
    }

    private int userID;
    private String name;
    private String lastName;
    private String userName;
    private int age;
    private String mail;
    private String address;
    private String postal;
    private String phone;
    private String typecard;
    private String month;
    private String year;
    private String card;
    private String state;
    private String discount;
}
