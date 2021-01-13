package com.example.crud.controller;

import com.example.crud.entity.Department;
import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.DepartmentAndEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Employee And Department controller", description = "Basic operation with data from db")
public class EmployeeAndDepartmentController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentAndEmployeeService service;

    //Get all departments with their users
    @GetMapping("/get/all/departments")
    @ApiOperation(value = "Return list of departments from database")
    public List<Department> getAllDepartmentsWithEmployee(){
        return service.getAllDepartmentsWithEmployees();
    }

    //Get one department
    @GetMapping("/get/one/department/{id}")
    @ApiOperation(value = "Return one departments from database by ID")
    public Department getOneDepartment(@PathVariable("id") int id){
        return service.getOneDepartment(id);
    }

    //Create department
    @PostMapping("/create/one/department")
    @ApiOperation(value = "Add one department to database")
    public Department createOneDepartment(@RequestBody Department department){
        return service.createOneDepartment(department);
    }

    //Delete department
    @DeleteMapping("/delete/one/department/{id}")
    @ApiOperation(value = "Delete one department from database by ID")
    public void deleteDepartment(@PathVariable("id") int id){
        service.deleteDepartment(id);
    }

    //Get one employee
    @GetMapping("/get/one/employee/{id}")
    @ApiOperation(value = "Return one employee from database by ID")
    public Employee getOneEmployee(@PathVariable("id") int id){
       return service.getOneEmployee(id);
    }

    //Create employee
    @PostMapping("/create/one/employee")
    @ApiOperation(value = "Add one employee to database")
    public Employee createOneEmployee(@RequestBody Employee employee){
        return service.createOneEmployee(employee);
    }

    //Delete employee
    @DeleteMapping("/delete/one/employee/{id}")
    @ApiOperation(value = "Delete one employee from database by ID")
    public void deleteOneEmployee(@PathVariable("id") int id){
        service.deleteEmployee(id);
    }

    //Add employee to department
    @PutMapping("/add/employee/to/department/{id}")
    @ApiOperation(value = "Add one employee to department by change ID")
    public Department addEmployeeToDepartment(@PathVariable("id") int id,
                                       @RequestBody int departmentId){
        service.addEmployeeToDepartment(id, departmentId);
        return service.getOneDepartment(departmentId);
    }

    //Remove employee from department
    @ApiOperation(value = "Delete one employee from department by ID")
    @PutMapping("/delete/employee/from/department/{id}")
    public Employee deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployeeFromDepartment(id);
    }

    //Get all employees which do not belong to any department
    @GetMapping("/get/all/employee/without/department")
    @ApiOperation(value = "Return list of employees who have department ID null")
    public List<Employee> getAllEmployeeWithoutDepartment(){
        return service.getAllEmployeeWithoutDepartment();
    }
}
