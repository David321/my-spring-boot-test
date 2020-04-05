package com.david.collectionTest;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
//        ArrayList arrayList;
        LinkedList linkedList;
//        Vector vector;
//
//        Set set;
//        List<String> list = new ArrayList<>();
//        list = Collections.synchronizedList(list);

        //面试题
        List list = new ArrayList();
        list.iterator();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        for(Object o:list){
            System.out.println(o);
        }
    }

    private static void updateList(List list){
        list.remove(2);// 注意，remove中的参数是index，按索引移除元素
    }
}
