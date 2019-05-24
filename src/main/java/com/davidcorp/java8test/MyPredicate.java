package com.davidcorp.java8test;

// 带泛型的接口
public interface MyPredicate<T> {
    public boolean test(T t);
}
