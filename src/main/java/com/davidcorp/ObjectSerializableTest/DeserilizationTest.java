package com.davidcorp.ObjectSerializableTest;

import com.davidcorp.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserilizationTest {
    public static void main(String[] args) {
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Student student = (Student)ois.readObject();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}