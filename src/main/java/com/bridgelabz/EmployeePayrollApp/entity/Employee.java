package com.bridgelabz.EmployeePayrollApp.entity;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employeeDB")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long id;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_dept",joinColumns = @JoinColumn(name = "id"))
    private List<String> department;

    public Employee(){}

    public Employee(EmployeeDTO employeeDTO){
        this.updateEmployeePayrollData(employeeDTO);
    }

    public void   updateEmployeePayrollData(EmployeeDTO employeeDTO) {
        this.name=employeeDTO.name;
        this.salary=employeeDTO.salary;
        this.gender=employeeDTO.gender;
        this.note=employeeDTO.note;
        this.startDate=employeeDTO.startDate;
        this.profilePic=employeeDTO.profilePic;
        this.department=employeeDTO.department;
    }

}
