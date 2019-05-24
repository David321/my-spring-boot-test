package com.davidcorp;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {

        try {
            Class<?> clazz = null;
            Method method = null;
            clazz = Class.forName("com.davidcorp.Fruit");
//            Constructor<Fruit> fruitConstructor = clazz.getConstructor(String.class);
//            Fruit fruit = fruitConstructor.newInstance("Apple");    //创建有参对象实例


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Fruit{
    public int num;
    private String type;
    public Fruit(){
        System.out.println("我是无参构造方法----------");
    }

    public Fruit(String type){
        System.out.println("我是有参构造方法----------"+type);
    }

    public int getNum() {
        return num;
    }
    public void show(){
        System.out.println("Fruit type = " + type);
    }
    public void show(int num){
        System.out.println("Fruit type = " + type + ".....Fruit num = " + num);
    }
}
