package com.davidcorp.dataStructureTest;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String, String> ht = new Hashtable<>();
        // hashtable不支持null值作为key或value
//        ht.put(null, "zhangsan");// 报错
//        ht.put("zhangsan", null);// 报错
        ht.put("name","david");
        ht.put("age","27");
        for(Map.Entry<String, String> entry:ht.entrySet()){
            System.out.println("key:"+entry.getKey()+"，value:"+entry.getValue());
        }
    }
}
