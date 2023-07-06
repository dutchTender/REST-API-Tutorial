package com.example.restapitutorial.persistence.dao;

import com.example.restapitutorial.persistence.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{

    @Override
    List<Employee> findAll();
    @Override
    List<Employee> findAll(Sort sort);
    Employee findByName(String name);

    @Override
    Optional<Employee> findById(Long id);

    @Override
    <S extends Employee> S save(S entity);

    @Override
    void delete(Employee entity);
}
