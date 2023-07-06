package com.example.restapitutorial.services;


import com.example.restapitutorial.persistence.dao.ManagerDAO;
import com.example.restapitutorial.persistence.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ManagerService implements ManagerServiceInterface {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ManagerDAO dao;

    @Override
    public Manager findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return dao.findById(id);
    }

    public List<Manager> findAll() {
        return dao.findAll();
    }

    public Manager save(Manager manager){

        return dao.save(manager);
    }

}
