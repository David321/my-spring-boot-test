package com.davidcorp.model;

import java.io.Serializable;

public class Dog implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }
}
