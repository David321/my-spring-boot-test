package com.davidcorp.java8test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 方法引用
 * */
public class TestLambda3 {
    // Java8四大内置函数式接口
    // consumer supplier function predicate

    // 有传入参数，无返回参数
    public static void test1(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    public static void main(String[] args) {
        Comparator<Integer> com = Integer::compareTo;
        Integer result = com.compare(1,2);
        System.out.println(result);
    }
}
