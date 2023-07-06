package com.example.restapitutorial.persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO {

    private Long id;
    private String name;
    private Long age;
    private String title;
    private Long salary;
    private String email;
    private Long mangerID;
}

/*
////example json payload////
{
    "name":"li zhang",
    "age":22,
    "title":"worker",
     "salary":"123",
    "email":"work@work.com",
    "mangerID":"1"
  }

 */