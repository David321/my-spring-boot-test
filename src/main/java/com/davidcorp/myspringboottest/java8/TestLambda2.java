package com.davidcorp.myspringboottest.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的基础语法
 * 函数式接口：只有一个抽象方法的接口
 */
public class TestLambda2 {

    public static void main(String[] args) {
        Comparator<Integer> com = (x, y) -> {
            Integer result = Integer.compare(x, y);
            System.out.println(result);
            return result;
        };
        com.compare(2,1);
    }

    // 无参的
    public void test1() {
        // 原来的写法
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        // Lambda表达式的写法
        Runnable runnable = () -> System.out.println("Hello World");
        runnable.run();
    }

    // 有一个参数
    public void test2(){
        Consumer<String> con = x -> System.out.println("Hello " + x);
        con.accept("World");
    }

    // 有2个参数
    public void test3(){
        Comparator<Integer> com = (x, y) -> {
            Integer result = Integer.compare(x, y);
            System.out.println(result);
            return result;
        };
    }

    // 只有一条语句，return和{}都可以省略
    public void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }
}
