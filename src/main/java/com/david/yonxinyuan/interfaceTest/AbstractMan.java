package com.david.yonxinyuan.interfaceTest;

public abstract class AbstractMan implements Person{
    // 抽象类中可包含抽象方法
    abstract public void eat();

    // 抽象类中可包含有具体实现的方法，非抽象方法
    public void watchTV(){
        System.out.println("man watch tv");
    }

    // 实现Person接口中的sayHello()
    public String sayHello(){
        return "hello";
    }
}
