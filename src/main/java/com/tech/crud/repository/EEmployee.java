package com.tech.crud.repository;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table
public class EEmployee {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;


    @Column
    private int salary;


    @Column(nullable = false)

    private Boolean contractBased = Boolean.FALSE;



    @Column
    private String organizationName;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isContractBased() {
        return contractBased;
    }

    public void setContractBased(boolean contractBased) {
        this.contractBased = contractBased;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public boolean getContractType() {
        return false;
    }
}
