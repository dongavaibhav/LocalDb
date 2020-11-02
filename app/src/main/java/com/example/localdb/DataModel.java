package com.example.localdb;

import javax.inject.Inject;

public class DataModel {

    private String ID;

    private String firstName;

    private String lastName;

    @Inject
    public DataModel() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
