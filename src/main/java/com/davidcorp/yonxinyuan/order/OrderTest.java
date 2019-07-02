package com.davidcorp.yonxinyuan.order;

import org.junit.Test;

import java.util.*;

public class OrderTest {

    Integer[] myIntegerArr = {3, 5, 6, 7, 9, 4, 1, 21, 36, 0};
    int[] myIntArr = {3, 5, 6, 7, 9, 4, 1, 21, 36, 0};

    @Test
    public void test1() {
        Arrays.sort(myIntegerArr);//默认升序
        for (int i = 0; i < myIntegerArr.length; i++) {
            System.out.println(myIntegerArr[i]);
        }
    }

    @Test
    public void test2() {
        // 采用方法引用，升序排列
        Comparator<Integer> com = Integer::compare;
        Arrays.sort(myIntegerArr, com);
        for (int i = 0; i < myIntegerArr.length; i++) {
            System.out.println(myIntegerArr[i]);
        }
    }

    @Test
    public void test3() {
        // 采用Lambda表达式，降序排列
        Comparator<Integer> com = (x, y) -> Integer.compare(y, x);
        Arrays.sort(myIntegerArr, com);
        for (int i = 0; i < myIntegerArr.length; i++) {
            System.out.println(myIntegerArr[i]);
        }
    }

    /**
     * 采用冒泡排序，对int数组进行升序排序
     */
    @Test
    public void test4() {
        int[] arr = {5, 2, 66, 3, 7};
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);

        }
    }

    /**
     * 采用冒泡排序，对int数组进行降序排序
     */
    @Test
    public void test5() {
        int[] arr = {5, 2, 66, 3, 7};
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {// 与test4中唯一的区别就在于这个小于号
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);

        }
    }

    /**
     思路：
     1、使用 HashSet 进行去重
     2、将 HashSet 变为 TreeSet
     3、使用 TreeSet 进行排序
     4、将 Set 变为 Integer 数组
     5、将 Integer 数组变为 int 数组
     */
    @Test
    public void test6(){
        int[] candidates = {1,1,2,2,2,9,8,7,76,84,54,45}; // 初始化一个需要排序、去重的int数组
        // 利用Set中元素的不可重复性
        HashSet<Integer> hashSet = new HashSet<>(); // 去重
        for (int i = 0; i < candidates.length; i++){
            hashSet.add(candidates[i]);
        }
        Comparator<Integer> com = (x, y)-> Integer.compare(y,x);
        Set<Integer> set = new TreeSet(hashSet);            // 利用TreeSet排序
        Integer[] integers = set.toArray(new Integer[]{});

        int[] result = new int[integers.length];            // 我们排序、去重后的结果数组
        for (int i = 0; i < integers.length; i++){
            result[i] = integers[i].intValue();
        }
        Arrays.stream(result).forEach(System.out::println); // 将结果数组输出
    }
}
