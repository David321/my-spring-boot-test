package com.david;

import com.david.model.Dog;
import com.david.model.Person4;
import com.david.util.CloneUtil;
import org.junit.Test;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
//        Map<String,String> map =Collections.emptyMap();
//        StringBuilder stringBuilder;
//        StringBuffer stringBuffer;

        int i1 = 10;
        Integer integer1 = new Integer(i1);
        Integer integer2 = new Integer("10");
        Integer integer3 = new Integer(10);

        int i2 = integer1.intValue();
        int i3 = Integer.parseInt("123");


        String string = String.valueOf(integer1);

        Boolean b = new Boolean("true");
        boolean b2 = b.booleanValue();

        Float f = new Float("12.3");
        float f2 = f.floatValue();

        Double d = new Double("12.3");
        double d2 = d.doubleValue();

        String s1 = String.valueOf(b);
        String s2 = String.valueOf(f);
        String s3 = String.valueOf(d);

    }

    public void test1(){
        String str1 = "123";
        int i1 = Integer.parseInt(str1);
        String str2 = "true";
        Boolean b = Boolean.parseBoolean(str2);
    }

    @Test
    public void test2(){
        int[] my_int_array = {1,2,3};
        System.out.println(my_int_array.length);
    }

    @Test
    public void test3(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(arrayList.size());
    }

    /**
     * 通过实现Cloneable接口实现对象的克隆
     * */
    @Test
    public void test4(){
        Person4 p1 = new Person4();
        p1.setId(1001);
        p1.setName("zhangsan");
//        p1.setDog(new Dog("wangcai"));
        Person4 p2 = (Person4) p1.clone();
        p2.setName("lisi");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
//        p2.getDog().setName("kele");
//        System.out.println(p1==p2);
//        System.out.println(p1.equals(p2));
//        System.out.println(p2.getDog().getName());
//        System.out.println(p1.getDog().getName());
    }

    /**
     * 通过序列化与反序列化实现对象的克隆
     * */
    @Test
    public void test5(){
        Person4 p1 = new Person4();
        p1.setId(1001);
        p1.setName("zhangsan");
        p1.setDog(new Dog("wangcai"));
        try {
            Person4 p2 = CloneUtil.clone(p1);
            p2.getDog().setName("kele");
            System.out.println(p1.getDog().getName());// wangcai
            System.out.println(p2.getDog().getName());// kele
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6(){
        try{
            System.out.println(123);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
