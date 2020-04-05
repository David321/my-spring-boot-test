package com.davidcorp.model;

import java.util.Objects;

public class Person2 implements Comparable<Person2>{
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

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person2() {
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id &&
                Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Person2 o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
