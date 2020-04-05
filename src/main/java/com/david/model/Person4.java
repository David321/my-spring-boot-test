package com.david.model;

import java.io.Serializable;
import java.util.Objects;

public class Person4 implements Cloneable, Serializable {
    private int id;
    private String name;
    private Dog dog;

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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person4(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person4() {
    }

    @Override
    public String toString() {
        return "Person4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Object clone() {
        Person4 person = null;
        try {
            person = (Person4)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person4 person4 = (Person4) o;
        return id == person4.id &&
                Objects.equals(name, person4.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
