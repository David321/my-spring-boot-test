package com.davidcorp.collectionTest;

import com.davidcorp.model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        // 去除list中重复的元素
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(list);
        list.clear();
        list = new ArrayList<>(hashSet);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public void test1(){
        TreeSet<Person> treeSet = new TreeSet<>();
        Person p1 = new Person();
        Person p2 = new Person();
        treeSet.add(p1);
        treeSet.add(p2);
    }
}
