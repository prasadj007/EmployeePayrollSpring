package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private List<Employee> employeeList=new ArrayList<>();

    public List<Employee>  getEmployeePayrollData()
    {
        return employeeList;
    }

    @Override
    public Employee getEmployeePayrollDataById(int empID) {

        return employeeList.get(empID-1);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee=null;
        employee=new Employee(employeeList.size()+1,employeeDTO);
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployeePayrollData(int empID,EmployeeDTO employeeDTO) {
        Employee employee=this.getEmployeePayrollDataById(empID);
        employee.setName(employeeDTO.name);
        employee.setSalary(employeeDTO.salary);
        return employee;
    }
    @Override
    public void deleteEmployeePayrollData(int empID) {
    employeeList.remove(empID-1);
    }




}
