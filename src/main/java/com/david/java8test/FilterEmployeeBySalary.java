package com.david.java8test;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
