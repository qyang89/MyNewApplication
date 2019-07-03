package com.example.mynewapplication;

import java.io.Serializable;

public class Person implements Serializable {

    private String name, dob, imageUrl;

    public Person(String name, String dob, String imageUrl) {
        this.name = name;
        this.dob = dob;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}














