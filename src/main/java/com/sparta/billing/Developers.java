package com.sparta.billing;

public class Developers extends Position {
    @Override
    public void addEmployee(Employee employee) {
        employee.rate+=5;
        super.addEmployee(employee);
    }
}
