package com.bridgelabz.EmployeePayrollApp.exception;


import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

    @ControllerAdvice
    public class EmployeePayrollExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
            List<String>errorMessage=errorList.stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            ResponseDTO responseDTO=new ResponseDTO("Exception while processing the rest result",errorMessage);
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EmployeePayrollException.class)
        public ResponseEntity<ResponseDTO> handleEmployeeException(EmployeePayrollException payrollException){
            ResponseDTO responseDTO=new ResponseDTO("Exception while processing the rest result",payrollException.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }

