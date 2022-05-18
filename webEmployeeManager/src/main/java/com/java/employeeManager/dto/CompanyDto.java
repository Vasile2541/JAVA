package com.java.employeeManager.dto;

import java.util.Set;

public class CompanyDto {
    private Integer id;
    private String name;
    private Set<Integer> employeesId;

    public CompanyDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
//Lombok setteri
    public CompanyDto(Integer id, String name, Set<Integer> employeesId) {
        this.id = id;
        this.name = name;
        this.employeesId = employeesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Set<Integer> employeesId) {
        this.employeesId = employeesId;
    }
}
