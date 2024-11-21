package com.example.H2database.service;

import com.example.H2database.dto.RequestDto;
import com.example.H2database.dto.ResponseDto;
import com.example.H2database.entity.Employee;

import java.util.List;

public interface EmployeeService {
       ResponseDto addEmployee(RequestDto requestDto);

       List<ResponseDto> getAllEmployee();

       ResponseDto getEmployeeById(long id);

       ResponseDto updateEmployee(long id, RequestDto requestDto);

       ResponseDto deleteEmployee(long id);
}
