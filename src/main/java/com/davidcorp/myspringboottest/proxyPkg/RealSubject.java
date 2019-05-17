package com.davidcorp.myspringboottest.proxyPkg;

public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
