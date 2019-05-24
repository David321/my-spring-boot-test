package com.davidcorp.java8test;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 35;
    }
}
