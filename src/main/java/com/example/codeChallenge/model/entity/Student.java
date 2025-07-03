package com.example.codeChallenge.model.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("student")
public class Student {

    @Id
    private Integer id;
    private String code;
    private String name;
    private String lastName;
    private String status;
    private int age;
}
