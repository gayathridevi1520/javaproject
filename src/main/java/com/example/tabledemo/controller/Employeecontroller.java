package com.example.tabledemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tabledemo.Repositories.Employeerespositories;
import com.example.tabledemo.model.Employee;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Employee")
public class Employeecontroller {
    @Autowired
    private Employeerespositories employeeRespository;
//craete 
@PostMapping
public Employee createEmployee(@RequestBody Employee employee){
    return employeeRespository.save(employee);

}
//getall employees
@GetMapping
public List<Employee> getEmployees(){
    return employeeRespository.findAll();
}
//get by id
@GetMapping("/{id}")
public Employee getbyId(@PathVariable int id){
    return employeeRespository.findById(id).orElse(null);
}
//update
@PutMapping("/{id}")
public Employee update(@PathVariable int id,@RequestBody Employee newemployee){
    Employee emp=employeeRespository.findById(id).orElse(null);
    if(emp!=null){
        emp.setName(newemployee.getName());
        emp.setPlace(newemployee.getPlace());
        return employeeRespository.save(emp);

    }
    return null;
   
}
//delete
@DeleteMapping("/{id}")
public String Delete(@PathVariable int id){
    if (employeeRespository.existsById(id)) {
        employeeRespository.deleteById(id);
        return "employee deleted";
    }
    else{
        return "employee not exist";
    }
    
}



}
