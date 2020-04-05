package com.david.java8test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8新特性：Stream API
 * 对集合进行操作，像SQL语句一样
 */
public class StreamTest {

    private List<Employee> employeeList = Arrays.asList(
            new Employee(1001, "诸葛亮", 55, 20000),
            new Employee(1002, "司马懿", 50, 5000),
            new Employee(1003, "曹操", 60, 7000),
            new Employee(1004, "刘备", 52, 8000),
            new Employee(1005, "孙权", 40, 9000),
            new Employee(1006, "关羽", 36, 10000));

    public static void main(String[] args) {
        // 创建流的几种方式
        // 第一种方式：通过 Collection 系列集合提供的方法 stream() 或者 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        // 第二种方式：由数组创建流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 第三种方式：由值创建流，Stream<T>
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 第四种方式：由函数创建流，创建无限流。两个静态方法。
        Stream<Integer> stream4_1 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream4_1.forEach(System.out::println);
        Stream<Double> stream4_2 = Stream.generate(() -> Math.random()).limit(10);
        stream4_2.forEach(System.out::println);

    }

    @Test
    public void test1() {
        // 中间操作不会做任何处理
        Stream<Employee> stream = employeeList.stream().filter(x -> {
            System.out.println("惰性求值");
            return x.getAge() < 30 && x.getSalary() > 7000;
        });
        System.out.println("-------------------------");
        // 终止操作，一次性执行全部功能， 称为 "惰性求值"
        stream.forEach(System.out::println);
    }

    /**
     * limit
     */
    @Test
    public void test2() {
        // 截断流，截取一个
        employeeList.stream().filter(x -> x.getAge() > 30).limit(1).forEach(System.out::println);
    }

    /**
     * skip
     */
    @Test
    public void test3() {
        // 跳过前2个
        employeeList.stream().filter(x -> x.getAge() < 30).skip(2).forEach(System.out::println);
    }

    /**
     * distinct
     */
    @Test
    public void test4() {
        // 去重
        employeeList.stream().distinct().forEach(System.out::println);
    }

    /**
     * map
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "java", "ccc", "java8", "hello world");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
    }

    /**
     * sorted
     */
    @Test
    public void test7() {
        // 自然排序
        employeeList.stream().map(Employee::getSalary).sorted().forEach(System.out::println);
        System.out.println("----------------------------------");
        // 定制排序
        employeeList.stream().map(Employee::getAge).sorted(Integer::compareTo).forEach(System.out::println);
    }

    /**
     * allMatch, anyMatch, noneMatch
     */
    @Test
    public void test8() {
        boolean allMatch = employeeList.stream().allMatch(x -> x.getName().equals("诸葛亮"));
        System.out.println(allMatch);
        System.out.println("-----------------------------------");
        boolean anyMatch = employeeList.stream().anyMatch(x -> x.getName().equals("诸葛亮"));
        System.out.println(anyMatch);
        System.out.println("-----------------------------------");
        boolean noneMatch = employeeList.stream().noneMatch(x -> x.getName().equals("诸葛亮"));
        System.out.println(noneMatch);
    }

    /**
     * findFirst
     */
    @Test
    public void test9() {
        Optional<Employee> first = employeeList.stream().filter(x -> x.getAge() > 50).findFirst();
        Boolean result = first.isPresent();
        System.out.println(result);
        if (result) {
            System.out.println(first.get());
        }
    }

    /**
     * findAny
     */
    @Test
    public void test10() {
        Optional<Employee> any = employeeList.stream().filter(x -> x.getAge() > 50).findAny();
        Boolean result = any.isPresent();
        System.out.println(result);
        if (result) {
            System.out.println(any.get());
        }
    }

    /**
     * count
     */
    @Test
    public void test11() {
        Stream<Employee> stream = employeeList.stream();
        long count = stream.count();
        System.out.println(count);
    }

    /**
     * max,min
     */
    @Test
    public void test12() {
        Optional<Integer> optional = employeeList.stream().map(Employee::getAge).max(Integer::compareTo);
        if (optional.isPresent()) {
            Integer result = optional.get();
            System.out.println(result);
        }
        System.out.println("---------------------------");
        Optional<Integer> optionalB = employeeList.stream().map(Employee::getAge).min(Integer::compareTo);
        if (optionalB.isPresent()) {
            Integer result = optionalB.get();
            System.out.println(result);
        }
        System.out.println("---------------------------");
        // 这种方式可直接取到完整对象
        Optional<Employee> optionalC = employeeList.stream().min((x, y) -> Integer.compare(x.getAge(), y.getAge()));
        if (optionalC.isPresent()) {
            Employee result = optionalC.get();
            System.out.println(result);
        }
    }

    /**
     * map reduce
     */
    @Test
    public void test13() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // param1:起始值，param2:计算规则
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("---------------------------");

        Optional<Double> doubleOptional = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::max);
        System.out.println(doubleOptional.get());

        System.out.println("---------------------------");

        Optional<Integer> integerOptional = employeeList.stream()
                .map(Employee::getAge)
                .reduce(Integer::max);
        System.out.println(integerOptional.get());

    }

    /**
     * collect
     */
    @Test
    public void test14() {
        // 把流中元素收集到List
        List<Integer> list = employeeList.stream().map(Employee::getAge).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("---------------------------");

        // 求个数
        long count = employeeList.stream().collect(Collectors.counting());
        System.out.println("count:" + count);

        // 求平均值
        Double avg = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("avg:" + avg);

        // 求和
        Double sum = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("sum:" + sum);

        // 求最大值
        Optional<Employee> max = employeeList.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(max.get());

        // 求最小值
        Optional<Double> min = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

        //统计分析
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics.getAverage());

        //拼接
        String join = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "--", "--"));
        System.out.println(join);

        // 分组
        Map<String, List<Employee>> group = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        System.out.println(group);
    }
}
