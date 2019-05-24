package com.davidcorp.dataStructureTest;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put(null,"david");
        hm.put(null,"obama");// HashMap可以接受null值作为key；且，put相同的key，会覆盖之前的
        hm.put("zhangsan", null);// hashmap可以接受null值作为value
        hm.put("addr","changsha");
        System.out.println("-----------"+hm.get("zhangsan"));
        // 遍历hashmap
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println("key:"+entry.getKey()+"，value:"+entry.getValue());
        }
    }
}
