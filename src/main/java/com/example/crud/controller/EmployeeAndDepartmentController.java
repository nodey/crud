package com.example.crud.controller;

import com.example.crud.entity.Department;
import com.example.crud.entity.Employee;
import com.example.crud.service.DepartmentAndEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeAndDepartmentController {

    final
    DepartmentAndEmployeeService service;

    public EmployeeAndDepartmentController(DepartmentAndEmployeeService service) {
        this.service = service;
    }

    //Get all departments with their users
    @GetMapping("/getAllDep")
    public ResponseEntity<List<Department>> getAllDepAndEmp(){
        List<Department> departments = service.getAllDepAndEmp();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //Get one department
    @GetMapping("/getOneDep/{id}")
    public ResponseEntity<Department> getOneDep(@PathVariable("id") Long id){
        Department department = service.getOneDep(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    //Create department
    @PostMapping("/addOneDep")
    public ResponseEntity<Object> createOneDep(@RequestBody Department department){
        Department createDep = service.create(department);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createDep.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Delete department
    @DeleteMapping("/delOneDep/{id}")
    public void deleteOneDep(@PathVariable("id") Long id){
        service.delete(id);
    }

    //Get one employee
    @GetMapping("/getOneEmp/{id}")
    public ResponseEntity<Employee> getOneEmp(@PathVariable("id") Long id){
        Employee employee = service.getOneEmp(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //Create employee
    //Delete employee
    //Add employee to department
    //Remove employee from department
    //Get all employees which do not belong to any department
}
