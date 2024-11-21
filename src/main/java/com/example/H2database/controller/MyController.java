package com.example.H2database.controller;

import com.example.H2database.dto.RequestDto;
import com.example.H2database.dto.ResponseDto;
import com.example.H2database.entity.Employee;
import com.example.H2database.service.EmployeeService;
import com.example.H2database.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
public class MyController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody RequestDto requestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(requestDto));
    }

    @GetMapping
    public List<ResponseDto> getEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseDto getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public ResponseDto updateEmployee(@PathVariable long id, @RequestBody RequestDto requestDto) {
        return employeeService.updateEmployee(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteEmployee(@PathVariable long id) {
        ResponseDto deletedEmployee = employeeService.deleteEmployee(id);
        return deletedEmployee;
    }

}
