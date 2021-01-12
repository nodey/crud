package com.example.crud.service;

import com.example.crud.entity.Department;
import com.example.crud.entity.Employee;
import com.example.crud.repository.DepartmentRepository;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentAndEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository DepartmentRepository;

    public List<Department> getAllDepAndEmp(){
        if(DepartmentRepository != null )
            return DepartmentRepository.findAll();
        return null;
    }

    public Department getOneDep(Long id){
        if(DepartmentRepository != null)
            return DepartmentRepository.findById(id).get();
        return null;
    }

    public Department create(Department department){
        if (DepartmentRepository != null)
            return DepartmentRepository.save(department);
        return null;
    }

    public void delete(Long id){
        DepartmentRepository.deleteById(id);
    }
    public Employee getOneEmp(Long id){
        if(employeeRepository != null)
            return employeeRepository.findById(id).get();
        return null;
    }
}
