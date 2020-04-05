package com.david.thread;

public class MyThread2 extends Thread{

    public MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("执行MyThread2的一些操作");
    }
}
