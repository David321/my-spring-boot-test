package com.davidcorp.Model;

public class Person {

    final String addr = "changsha";

    static{
        System.out.println("我是Person类的静态代码块----------");
    }

    String name;
    String age;

    {
        System.out.println("我是构造代码块--------------------");
    }

    public void sayHello(){
        System.out.println("hello-------------");
    }

    // 这是构造方法
    public Person(String name, String age){
        System.out.println("我是构造方法，name="+name+"，age="+age);
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
