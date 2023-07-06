package com.example.restapitutorial.services;

import com.example.restapitutorial.persistence.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    public Employee findByName(String name);
    public java.util.Optional<Employee> findById(Long Id);

    public List<Employee> findAll();

    public Employee save(Employee resource);


}
