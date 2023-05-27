package com.tech.crud.entity;


import javax.persistence.*;


public class Employee {

    @GeneratedValue
    private int id;

    private String name;

    private int salary;


    private boolean contractBased;

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

    public boolean isContractBased(String datum) {
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

    public boolean isContractBased() {
        return contractBased;
    }


}
