package com.david.collectionTest.comparableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 集合实现自定义排序
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setOrder(1);
        User user2 = new User();
        user2.setName("lisi");
        user2.setOrder(2);
        User user3 = new User();
        user3.setName("wangwu");
        user3.setOrder(3);
        User user4 = new User();
        user4.setName("zhaoliu");
        user4.setOrder(4);
        List<User> list = new ArrayList<User>();
        // List是有序的，这里先add user2
        list.add(user4);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Collections.sort(list);
        for (User user : list){
            System.out.println(user.getName());
        }
    }
}
