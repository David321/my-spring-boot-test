package com.davidcorp.myspringboottest;

public class Test {
    public static void main(String[] args) throws InterruptedException{
        MyThread2 myThread2 = new MyThread2("DavidPeng创建的线程");
        Person person = new Person();
        person.wait();
        myThread2.join();
        System.out.println("当前线程名称：" + myThread2.getName());
    }
}
