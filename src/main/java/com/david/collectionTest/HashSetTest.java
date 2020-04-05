package com.david.collectionTest;

import com.david.model.Dog;
import com.david.model.Person;
import com.david.model.Person2;
import com.david.model.Person3;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {
        // HashSet底层是HashMap
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "david");// HashMap存储key-value形式的数据

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("david");// HashSet只能存储单个数据，不能存储key-value形式的数据
        hashSet.add(null);// 允许null值
    }

    /**
     * 一个笔试题，考HashSet的数据结构，掌握了这道题就掌握了HashSet的数据结构。
     * */
    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person2 p1 = new Person2(1001, "AA");
        Person2 p2 = new Person2(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);// 不会移除p1，因为执行remove方法要先计算对象的hash值，判断是否存在，
        // 存在才删除。但是p1的name变了，变成CC了，所以计算得出的hash值与原来存的时候的hash值不一样，所以不会移除。
        System.out.println(set);// [Person2{id=1002, name='BB'}, Person2{id=1001, name='CC'}]
        set.add(new Person2(1001, "CC"));// 这是因为本次add的时候，是根据1001、CC来计算hash值，
        // 而现在set中已经存在的1001、CC所存放的位置的hash值是根据
        // 1001、AA来计算的，所以这两个对象是不同的对象，所以都会存进去
        System.out.println(set);// [Person2{id=1002, name='BB'}, Person2{id=1001, name='CC'}, Person2{id=1001, name='CC'}]
        set.add(new Person2(1001, "AA"));// 这里计算的hash值虽然与第一次添加进去的1001、AA是一致的，
        // 但是之前那个对象的属性值已经变成1001、CC，所以对象执行equals会返回false，即这两个对象也是不相等的。
        System.out.println(set);// [Person2{id=1002, name='BB'}, Person2{id=1001, name='CC'},
        // Person2{id=1001, name='CC'}, Person2{id=1001, name='AA'}]
    }

    /**
     * HashSet中可以添加不同类的对象
     * */
    @Test
    public void test2(){
        HashSet set = new HashSet();
        Person person = new Person();
        Dog dog = new Dog();
        set.add(person);
        set.add(dog);
        System.out.println(set);
    }

    /**
     * TreeSet中可以添加不同类的对象吗？
     * */
    @Test
    public void test3(){
        TreeSet set = new TreeSet();
//        Person person = new Person();
        Person2 person = new Person2();
//        Dog dog = new Dog();
        set.add(person);
//        set.add(dog);
        System.out.println(set);
    }

    /**
     * 是不是指明泛型的类型就可以添加进去？
     *
     * 报错
     * java.lang.ClassCastException: com.davidcorp.Model.Person3 cannot be cast to java.lang.Comparable
     * */
    @Test
    public void test4(){
        TreeSet<Person3> set = new TreeSet();
        Person3 person3 = new Person3();
        set.add(person3);
        System.out.println(set);
    }

    /**
     * 添加到HashSet中的对象所在的类无需实现Comparable接口，因为HashSet不具备排序的功能。
     * 运行不报错
     * */
    @Test
    public void test5(){
        HashSet<Person3> set = new HashSet();
        Person3 person3 = new Person3();
        set.add(person3);
        System.out.println(set);
    }

    /**
     * Comparator定制排序怎么用？
     * */
    @Test
    public void test6(){
//        Comparator<Person3> comparator = (x,y)->Integer.compare(x,y);
//        TreeSet<Person3> set = new TreeSet(comparator);
//        Person3 person3 = new Person3();
//        set.add(person3);
//        System.out.println(set);
    }
}
