package com.example.codeChallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String code;
    private String name;
    private String lastName;
    private String status;
    private int age;
}
