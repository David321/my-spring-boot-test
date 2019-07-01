package com.davidcorp.collectionTest.comparableTest;

import java.util.Comparator;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        // 对比Comparable与Comparator
        Comparable comparable;
        Comparator comparator;

        Comparator<Integer> comparator1 = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(comparator1);
    }
}
