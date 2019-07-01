package com.davidcorp.java8test;

import java.util.*;

public class TestLambda {

    public void test1() {
        // 匿名内部类的方式
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    // 改进：采用lambda表达式的方式
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    // 继续改进，采用方法引用
    public void test3() {
        Comparator<Integer> com = Integer::compareTo;
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //需求：获取公司中年龄小于 35 的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if (emp.getAge() <= 35) {
                list.add(emp);
            }
        }

        return list;
    }

    //需求：获取公司中工资大于 5000 的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if (emp.getSalary() >= 5000) {
                list.add(emp);
            }
        }

        return list;
    }

    // 每次来个新的需求，就要创建个新的方法，添加新的过滤规则，这样很麻烦。

    // 优化方式一：采用设计模式，策略模式
    // 定义一个MyPredicate接口，该接口包含一个test()方法;
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    // 创建一个新的类实现MyPredicate接口，每个类就是一个过滤规则。
    // 将过滤规则作为参数传进来
    public void test4() {
        List<Employee> list = filterEmployee(emps, new FilterEmployeeByAge());
        List<Employee> list2 = filterEmployee(emps, new FilterEmployeeBySalary());
    }

    // 上面的优化方式也不是很灵活，于是我们考虑第二种优化方式，匿名内部类
    // 这样就可以少创建很多类，简化了代码
    public void test5() {
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });
    }

    // 匿名内部类可以继续优化成Lambda表达式的写法
    public void test6() {
        List<Employee> list = filterEmployee(emps, (e) -> e.getSalary() > 5000);// 箭头左边是参数，右边是表达式

    }

    public void test7(){
        emps.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }

    public void test8(){
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
