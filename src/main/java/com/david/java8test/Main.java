package com.david.java8test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    //需求：获取公司中年龄小于 35 的员工信息
    public static List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getAge() <= 35){
                list.add(emp);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Employee> list = filterEmployeeAge(emps);
        System.out.println(list);

    }
}
