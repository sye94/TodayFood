package com.sye.todayfood.model.response;

/**
 * Created by SYE on 2018-03-20.
 */

public class User {
    public final String firstName;
    public final String lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
