package com.example.restapitutorial.persistence.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
//@Table(name = "Manager", schema = "oif_ods")
@Table(name = "Manager")
public class Manager {

    @Id
    @Column(name = "manager_id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    //@SequenceGenerator(name = "user_seq_gen", sequenceName = "oif_ods.user_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "manager_name")
    private String name;
    private Long managedContractValue;
    private String programName;
    private Long salary;
    private String email;

    @OneToMany(mappedBy = "programManager") // references java object field/property name
    private Set<Employee> subordinates;


    public Employee addSubordinate(Employee employee){
        subordinates.add(employee);
        return employee;
    }
    public void removeSubordinate(Employee employee){
        subordinates.remove(employee);
    }

}

/*
example payload to string equivalent
{
    "name":"xxxxx",
    "managedContractValue":"20000000",
    "programName":"worker",
    "salary":"123",
    "email":"manager@work.com"

 }

        */