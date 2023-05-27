package com.tech.crud.controller;

import com.tech.crud.entity.Employee;
import com.tech.crud.repository.EEmployee;
import com.tech.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EEmployee addEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }


    @GetMapping("/emp")
    public List<EEmployee> getEmployees(){

        return (List<EEmployee>) employeeService.getEmployees();
    }

    @GetMapping("/sorted-by-name")
    public List<EEmployee> getAllEmployeesSortedByName(){

        return employeeService.getAllEmployeesSortedByName();


    }


    @GetMapping("/highest-paid")
    public EEmployee getHighestPaidEmployee(){
        return employeeService.getHighestPaidEmployee();
    }



    @GetMapping("/lowest-paid")
    public EEmployee getLowestPaidEmployee(){

        return employeeService.getLowestPaidEmployee();

    }



    @GetMapping(path = "/{id}/contract-based")
    public ResponseEntity<Boolean> isContractBasedEmployee(@PathVariable int id){

        boolean isContractBased = employeeService.isContractBasedEmployee(id);

        if (!isContractBased){
            return ResponseEntity.notFound().build();
        }
        return (ResponseEntity<Boolean>) ResponseEntity.ok(false);



    }

    @GetMapping(path = "/{id}/organization-name")
    public ResponseEntity<String> getOrganizationName(@PathVariable int id){

        String organizationName = employeeService.getOrganizationName(id);
        if (organizationName == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(organizationName);
    }

    @GetMapping(path = "/{id}")
    public EEmployee getEmployee(@PathVariable int id){

        return employeeService.getEmployee(id);

    }

    @PutMapping()
    public EEmployee updateEmployee(@RequestBody Employee employee){

        return employeeService.update(employee);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteEmployee(@PathVariable int id){

        return employeeService.delete(id);

    }

    @PostMapping("/csv")
    @ResponseStatus(HttpStatus.CREATED)
    public EEmployee createEmployeeFromCSV(@RequestParam("file")MultipartFile file){

        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                Employee employee = new Employee();

                employee.setContractBased(Boolean.parseBoolean(data[1]));
                employee.setName(data[2]);
                employee.setOrganizationName(data[3]);
                employee.setSalary(Integer.parseInt(data[4]));
                employeeService.createEmployee(employee);


            }
            reader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeService.createEmployee();
    }


    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }





}
