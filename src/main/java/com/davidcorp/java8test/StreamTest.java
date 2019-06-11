package com.davidcorp.java8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java8新特性：Stream API
 * 对集合进行操作，像SQL语句一样，limit
 * */

public class StreamTest {
    public static void main(String[] args) {
        // 方式1
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        int i = 0;

        // 方式2
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 方式3
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        // 方式4，创建无限流
//        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
//        stream4.limit(10).forEach(System.out::println);

        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);

    }
}
