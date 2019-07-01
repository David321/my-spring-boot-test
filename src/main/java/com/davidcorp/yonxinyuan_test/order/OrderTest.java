package com.davidcorp.yonxinyuan_test.order;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OrderTest {

    Integer[] myIntArr = {3,5,6,7,9,4,1,21,36,0};

    @Test
    public void test1() {
        Arrays.sort(myIntArr);//默认升序
        for(int i=0;i<myIntArr.length;i++){
            System.out.println(myIntArr[i]);
        }
    }

    @Test
    public void test2(){
        // 采用方法引用，升序排列
        Comparator<Integer> com = Integer::compare;
        Arrays.sort(myIntArr, com);
        for(int i=0;i<myIntArr.length;i++){
            System.out.println(myIntArr[i]);
        }
    }

    @Test
    public void test3(){
        // 采用Lambda表达式，降序排列
        Comparator<Integer> com = (x, y) -> Integer.compare(y, x);
        Arrays.sort(myIntArr, com);
        for(int i=0;i<myIntArr.length;i++){
            System.out.println(myIntArr[i]);
        }
    }
}
