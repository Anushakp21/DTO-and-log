package com.example.H2database.entity;

import com.example.H2database.dto.RequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
    private String address;
    private int age;
    private LocalDate doj;

    public Employee(RequestDto requestDto)
    {
        this.fName=requestDto.getFName();
        this.lName=requestDto.getLName();
        this.age=requestDto.getAge();
        this.address=requestDto.getAddress();
        this.doj=LocalDate.now();
    }
}
