package com.example.restapitutorial.controllers;

import com.example.restapitutorial.persistence.dto.EmployeeDTO;
import com.example.restapitutorial.persistence.model.Employee;
import com.example.restapitutorial.persistence.model.Manager;
import com.example.restapitutorial.services.EmployeeServiceInterface;
import com.example.restapitutorial.services.ManagerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeServiceInterface employeeService;
    ManagerServiceInterface managerService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return  employeeService.findAll();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getAEmployee(@PathVariable("id") final Long id){
        return "employee "+id;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @ResponseBody
    public Employee createAEmployee(@RequestBody final EmployeeDTO resource) {

        Employee employee = new Employee();
        employee.setName(resource.getName());
        employee.setAge(resource.getAge());
        employee.setEmail(resource.getEmail());
        employee.setTitle(resource.getTitle());
        employee.setSalary(resource.getSalary());
        Optional<Manager> manager = managerService.findById(resource.getMangerID());
        employee.setProgramManager(manager.get());
        return  employeeService.save(employee);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAEmployee(@PathVariable("id") final Long id, @RequestBody final EmployeeDTO resource) {
        return "updating  a employee "+id+" with new info :"+resource;

    }

}
