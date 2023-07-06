package com.example.restapitutorial.services;

import com.example.restapitutorial.persistence.model.Employee;
import com.example.restapitutorial.persistence.model.Manager;

import java.util.List;

public interface ManagerServiceInterface {

    public Manager findByName(String name);
    public java.util.Optional<Manager> findById(Long Id);

    public List<Manager> findAll();

    public Manager save(Manager resource);
}
