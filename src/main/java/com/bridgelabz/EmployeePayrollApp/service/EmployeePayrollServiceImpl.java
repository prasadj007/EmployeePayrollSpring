package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.Employee;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    //private List<Employee> employeeList=new ArrayList<>();
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee>  getEmployeePayrollData()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeePayrollDataById(long empID) {

        return employeeRepository.findById(empID)
                .orElseThrow(()->new EmployeePayrollException("Employee with this id doesnt exist"));
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee=null;
        employee=new Employee(employeeDTO);
        log.debug("Employee Data:"+employee.toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeePayrollData(int empID,EmployeeDTO employeeDTO) {
        Employee employee=this.getEmployeePayrollDataById(empID);
        employee.updateEmployeePayrollData(employeeDTO);
        return employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployeePayrollData(int empID) {
    Employee employee = this.getEmployeePayrollDataById(empID);
    employeeRepository.delete(employee);
    }

}
