package com.example.restapitutorial.persistence.dao;
import com.example.restapitutorial.persistence.model.Manager;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ManagerDAO extends JpaRepository<Manager, Long>, JpaSpecificationExecutor<Manager>{

    @Override
    List<Manager> findAll();
    @Override
    List<Manager> findAll(Sort sort);
    Manager findByName(String name);

    @Override
    Optional<Manager> findById(Long id);

    @Override
    <S extends Manager> S save(S entity);

    @Override
    void delete(Manager entity);
}
