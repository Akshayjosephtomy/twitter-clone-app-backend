package com.nestdigital.twittercloneappbackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class TwitterModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dob;
    private String phone;
    private String place;
    private String email;
    private String pass;

    public TwitterModel() {
    }

    public TwitterModel(int id, String name, String dob, String phone, String place, String email, String pass) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.place = place;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
