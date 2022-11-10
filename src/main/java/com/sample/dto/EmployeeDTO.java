package com.sample.dto;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String dep;
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, String dep, double salary) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDep() {
        return this.dep;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}