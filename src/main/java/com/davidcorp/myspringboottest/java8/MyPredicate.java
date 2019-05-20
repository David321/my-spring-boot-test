package com.davidcorp.myspringboottest.java8;

// 带泛型的接口
public interface MyPredicate<T> {
    public boolean test(T t);
}
