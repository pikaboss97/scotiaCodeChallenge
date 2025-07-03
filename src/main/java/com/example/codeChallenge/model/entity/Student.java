package com.example.codeChallenge.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("student")
public class Student {

    @Id
    private Integer id;
    private String code;
    private String name;
    private String lastName;
    private String status;
    private int age;

    public Student () {

    }
}
