package com.bridgelabz.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO {

    //@NotEmpty(message="Enter Your Name")
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}",message = "Enter Valid Name")
    public String name;
    @Min(value = 5000,message = "salary should not be less than 5000")
    public long salary;
    public String gender;
   // @JsonFormat(pattern = "dd mm yyyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;


    public EmployeeDTO(String name, long salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                ", note='" + note + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", department=" + department +
                '}';
    }
}
