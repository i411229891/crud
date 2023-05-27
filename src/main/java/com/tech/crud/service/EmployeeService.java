package com.tech.crud.service;

import com.tech.crud.entity.Employee;
import com.tech.crud.repository.EEmployee;
import com.tech.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired

    private EmployeeRepository employeeRepository;


    public Iterable<EEmployee> getEmployees(){

        return employeeRepository.findAll();
    }

    public List<EEmployee> getAllEmployeesSortedByName() {

        return (List<EEmployee>) employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }


    public EEmployee getHighestPaidEmployee(){


        return employeeRepository.findTopByOrderBySalaryDesc();

    }

    public EEmployee getLowestPaidEmployee(){

        return employeeRepository.findTopByOrderBySalaryAsc();
    }

    public boolean isContractBasedEmployee(int id){

        EEmployee employee = employeeRepository.findById(id).orElse(null);
        return employee != null && employee.isContractBased();

    }



    public String getOrganizationName(int id){

        EEmployee employee = employeeRepository.findById(id).orElse(null);
        return employee != null?employee.getOrganizationName():null;
    }

    public EEmployee save(Employee emp){


        EEmployee employee = new EEmployee();
        employee.setName(emp.getName());
        employee.setSalary(emp.getSalary());
        employee.setOrganizationName(emp.getOrganizationName());
        employee.setContractBased(emp.isContractBased());


        return employeeRepository.save(employee);
    }

    public EEmployee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    public EEmployee update(Employee employee){
        EEmployee emp = employeeRepository.findById(employee.getId()).get();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setContractBased(employee.isContractBased());
        emp.setOrganizationName(employee.getOrganizationName());
        return employeeRepository.save(emp);

    }


    public String delete(int id){

        employeeRepository.deleteById(id);
        return "Entity deleted" + id;
    }

    public EEmployee createEmployee(Employee emp){
        EEmployee employee = new EEmployee();
        employee.setName(emp.getName());
        employee.setSalary(emp.getSalary());
        employee.setOrganizationName(emp.getOrganizationName());
        employee.setContractBased(emp.isContractBased());


        return employeeRepository.save(employee);
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EEmployee createEmployee() {
        return null;
    }
}

