package com.example.restapitutorial.persistence.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
//@Table(name = "user", schema = "oif_ods")
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    //@SequenceGenerator(name = "user_seq_gen", sequenceName = "oif_ods.user_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_name")
    private String name;
    private Long age;
    private String title;
    private Long salary;
    private String email;


    @ManyToOne
    @JoinColumn(name="manager_id") //references db column name
    private Manager programManager;
}

/*
example payload to string equivalent
{
    "name":"xxxxx",
    "age":22,
    "title":"worker",
     "salary":"123",
    "email":"work@work.com",
    "programManager":"1"
  }

        */
