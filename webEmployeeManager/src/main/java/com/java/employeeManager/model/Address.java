package com.java.employeeManager.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String streetInfo;

    @OneToOne(mappedBy = "address")// este mapat de proprietatea de acolo adica cidn cauta legaura asta dintreaceste doua tabele legatura se pastreaza doar acolo , si nu in acest tabel, legatura se afla doar in tabelul care are o mai mare importnta din punct de vedere arhitectural\
    //hibernate o sa se ducca in clasa Employee si o sa caute Employee care are care are id al adresei egal cu id adresei din acesta clasa (daca adresa acolo e mapata atunci sunt acleasi id-uri) data ,pe urma va extrage Employee carui ii este atribuit aceasta adresa
    private Employee employee;

    public Address() { }

    public Address(String streetInfo) {
        this.streetInfo = streetInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetInfo() {
        return streetInfo;
    }

    public void setStreetInfo(String address) {
        this.streetInfo = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
