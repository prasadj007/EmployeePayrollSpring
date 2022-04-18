package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.Employee;

import java.util.List;

public interface EmployeePayrollService {

  List<Employee> getEmployeePayrollData();
  Employee getEmployeePayrollDataById(long empID);
  Employee  createEmployee(EmployeeDTO employeeDTO);
  Employee  updateEmployeePayrollData(int empId,EmployeeDTO employeeDTO);
  void deleteEmployeePayrollData(int empID);
}
