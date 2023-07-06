package com.example.restapitutorial.persistence.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Set;
@Getter
@Setter
@ToString
public class ManagerDTO {

    private Long id;
    private String name;
    private Long managedContractValue;
    private String programName;
    private Long salary;
    private String email;
    private Set<Long> subordinatesIDs;

}

/*
////example json payload////

{
    "name":"mr manager",
    "managedContractValue":"20000000",
    "programName":"usgs volcano early warning",
    "salary":"123",
    "email":"manager@work.com",
    "subordinatesIDs":[]

 }

 */