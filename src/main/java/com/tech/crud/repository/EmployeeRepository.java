package com.tech.crud.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EEmployee,Integer> {

    List<EEmployee> findAll(Sort salary);

    EEmployee findTopByOrderBySalaryDesc();

    EEmployee findTopByOrderBySalaryAsc();
}
