package com.wrongkey.spitter;

/**
 *@author wrongkey
 *@description
 *@date 2014/11/6
 *@version v1.0
 *
 */
public class Person {
    private int id;              //编号
    private String lastName;     //lastname
    private String firstName;    //firstname
    private String address;      //地址
    private String city;         //城市

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person information:\nId:        "+id+"\nFirstname: "+firstName+"\nLastname:  "+
                lastName+"\nAddress:   " + address+"\nCity:      "+city;
    }
}
