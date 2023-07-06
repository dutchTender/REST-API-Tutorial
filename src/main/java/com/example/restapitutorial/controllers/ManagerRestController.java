package com.example.restapitutorial.controllers;


import com.example.restapitutorial.persistence.dto.ManagerDTO;
import com.example.restapitutorial.persistence.model.Employee;
import com.example.restapitutorial.persistence.model.Manager;
import com.example.restapitutorial.services.EmployeeService;
import com.example.restapitutorial.services.EmployeeServiceInterface;
import com.example.restapitutorial.services.ManagerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerRestController {

    @Autowired
    ManagerServiceInterface managerService;
    EmployeeServiceInterface employeeService;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    @ResponseBody
    public List<Manager> getAllManagers(){
        return  managerService.findAll();
    }

    @RequestMapping(value = "/managers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getAManager(@PathVariable("id") final Long id){
        return "manager "+id;
    }

    @RequestMapping(value = "/managers", method = RequestMethod.POST)
    @ResponseBody
    public Manager createAManager(@RequestBody final ManagerDTO resource) {

        Manager manager = new Manager();
        manager.setName(resource.getName());
        manager.setSalary(resource.getSalary());
        manager.setProgramName(resource.getProgramName());
        manager.setManagedContractValue(resource.getManagedContractValue());
        manager.setEmail(resource.getEmail());
        if(resource.getSubordinatesIDs().size() > 0){
            for ( Long workerID :resource.getSubordinatesIDs()) {
                  Optional<Employee> employee = employeeService.findById(workerID);
                  manager.addSubordinate(employee.get());
            }
        }
        return  managerService.save(manager);
    }


    @RequestMapping(value = "/managers/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAManager(@PathVariable("id") final Long id, @RequestBody final ManagerDTO resource) {
        // user/live exercise - write code here
        return "updating  a employee "+id+" with new info :"+resource;
    }

}
