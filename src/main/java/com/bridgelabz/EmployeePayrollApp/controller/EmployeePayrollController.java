package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.entity.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<Employee> employeeList=null;
        employeeList =employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Succes", employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empID") int empId) {
        Employee employee=null;
        employee =employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Employee by Id",employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO=new ResponseDTO("Deleted Succesfully",empId);
        return new ResponseEntity<>("Get call success for Id:"+empId, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employee=null;
        employee=employeePayrollService.createEmployee(employeeDTO);
       ResponseDTO responseDTO= new ResponseDTO("Created Employee data For",employee);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empID") int empId,@RequestBody EmployeeDTO employeeDTO){
        Employee employee=null;
        employee=employeePayrollService.updateEmployeePayrollData(empId,employeeDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated EmpPayroll data Sucessfully",employee);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }



}
