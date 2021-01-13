package com.example.crud.service;

import com.example.crud.entity.Department;
import com.example.crud.entity.Employee;
import com.example.crud.repository.DepartmentRepository;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentAndEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartmentsWithEmployees(){
        if(departmentRepository != null )
            return departmentRepository.findAll();
        return null;
    }

    public Department getOneDepartment(int id){
        if(departmentRepository != null)
            return departmentRepository.findById(id).get();
        return null;
    }

    public Department createOneDepartment(Department department){
        if (departmentRepository != null)
            return departmentRepository.save(department);
        return null;
    }

    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

    public Employee getOneEmployee(int id){
        if(employeeRepository != null)
            return employeeRepository.findById(id).get();
        return null;
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }

    public Employee createOneEmployee(Employee employee){
        if (employeeRepository != null)
            return employeeRepository.save(employee);
        return null;
    }

    public Employee deleteEmployeeFromDepartment(int id){
        Employee employee = getOneEmployee(id);
        employee.setDepartmentId(0);
        return employeeRepository.save(employee);
    }


    public Employee addEmployeeToDepartment(int id, int departmentId){
        Employee employee = getOneEmployee(id);
        employee.setDepartmentId(departmentId);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeeWithoutDepartment(){
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> finalList = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++){
            Employee employeeDepartmentId = employees.get(i);
            if(employeeDepartmentId.getDepartmentId() == 0){
                finalList.add(employeeDepartmentId);
            }
        }return finalList;
    }
}
