package com.java.employeeManager.dto;

public class EmployeeDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Integer companyId;
    private String address;
//    private AddressDto addressDto; //in loc de: address

    public EmployeeDto() {
    }

    //doar clasele care treb sa fie reprezentate in exterior, se fas DTo clase


    public EmployeeDto(Integer id, String firstName, String lastName, Double salary, Integer companyId, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.companyId = companyId;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
