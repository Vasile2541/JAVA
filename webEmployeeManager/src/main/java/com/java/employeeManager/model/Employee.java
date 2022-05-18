package com.java.employeeManager.model;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "app")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column()
    private Double salary;
//
    @ManyToOne
    private Company company;

    @OneToOne(cascade = CascadeType.ALL )//operatie cascada cind facem o operatie cu Employee este afectata si Adresa , de ex la stergerea Employee se sterge si Adressa
    //legind astfel obiectele ALL, noi de fapt nici  nuavem nevoie sa gestionat separat clasa Adresa
    private Address address;

    public Employee() { }

    public Employee( String firstName, String lastName, Double salary, Company company, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
        this.address = address;
    }

    public Employee(int id, String firstName, String lastName, Double salary, Company company, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
