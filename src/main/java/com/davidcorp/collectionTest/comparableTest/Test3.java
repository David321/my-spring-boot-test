package com.davidcorp.collectionTest.comparableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 如下代码实现对集合的自定义排序也用到了策略模式，传一个Comparator接口的实现类进去，自定义排序规则。
public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(6);
        list.add(8);
        list.add(1);
        list.add(5);
        list.add(2);
        // 原来的写法
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;// 第一个减第二个，升序
//                return o2 - o1;// 第二个减第一个，降序
            }
        });

        // 改进，使用Lambda表达式
        Collections.sort(list, (x, y) -> Integer.compare(x, y));// 升序
        Collections.sort(list, (x, y) -> Integer.compare(y, x));// 降序

        // 改进，使用方法引用
        Collections.sort(list, Integer::compareTo);// 升序

        for(Integer i : list){
            System.out.println(i);
        }
    }
}
