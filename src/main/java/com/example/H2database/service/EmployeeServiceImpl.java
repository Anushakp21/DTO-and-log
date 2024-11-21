package com.example.H2database.service;

import com.example.H2database.dto.RequestDto;
import com.example.H2database.dto.ResponseDto;
import com.example.H2database.entity.Employee;
import com.example.H2database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseDto addEmployee(RequestDto requestDto) {
        Employee emp = mapToEmployeeEntity(requestDto);
        emp = employeeRepository.save(emp);
        return mapToResponseDto(emp);
    }

    public Employee mapToEmployeeEntity(RequestDto req) {
        Employee e = new Employee(req);
        return e;
    }

    public ResponseDto mapToResponseDto(Employee e) {
        ResponseDto res = new ResponseDto();
        res.setId(e.getId());
        res.setFName(e.getFName());
        res.setLName(e.getLName());
        res.setAge(e.getAge());
        res.setAddress(e.getAddress());
        return res;
    }
    @Override
    public List<ResponseDto> getAllEmployee()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
    @Override
    public ResponseDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        return mapToResponseDto(employee);
    }

    @Override
    public ResponseDto updateEmployee(long id, RequestDto requestDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));

        existingEmployee.setFName(requestDto.getFName());
        existingEmployee.setLName(requestDto.getLName());
        existingEmployee.setAddress(requestDto.getAddress());
        existingEmployee.setAge(requestDto.getAge());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return mapToResponseDto(updatedEmployee);
    }

    @Override
    public ResponseDto deleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));

        // Map to ResponseDto before deletion
        ResponseDto responseDto = mapToResponseDto(existingEmployee);

        employeeRepository.delete(existingEmployee);

        return responseDto;
    }

}