package com.caloriecounter.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String loginName;

    int dailyCH;

    public User(){}

    public User(String loginName, int dailyCH) {
        this.loginName = loginName;
        this.dailyCH = dailyCH;
    }
}
