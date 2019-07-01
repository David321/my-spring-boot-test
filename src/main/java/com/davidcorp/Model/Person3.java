package com.davidcorp.Model;

public class Person3 {
    private int id;
    private String name;
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

    public Person3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person3() {
    }

    @Override
    public String toString() {
        return "Person3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
