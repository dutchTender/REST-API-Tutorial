package com.example.restapitutorial.services;

import com.example.restapitutorial.persistence.dao.EmployeeDAO;
import com.example.restapitutorial.persistence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EmployeeDAO dao;

    @Override
    public Employee findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return dao.findById(id);
    }

    public List<Employee> findAll() {
        return dao.findAll();
    }

    public Employee save(Employee employee){

        return dao.save(employee);
    }

}
