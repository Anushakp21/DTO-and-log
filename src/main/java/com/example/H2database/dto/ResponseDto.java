package com.example.H2database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class ResponseDto {
    private long id;
    private String fName;
    private String lName;
    private String address;
    private int age;
}
