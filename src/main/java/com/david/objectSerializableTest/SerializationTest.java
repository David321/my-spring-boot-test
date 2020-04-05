package com.david.objectSerializableTest;

import com.david.model.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializationTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("19");
        student.setName("zhangsan");
//        System.out.println(student);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(student);
            System.out.println("序列化完成----------------");// 持久化文件保存在当前项目的根目录下
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
