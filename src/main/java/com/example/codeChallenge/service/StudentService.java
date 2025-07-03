package com.example.codeChallenge.service;

import com.example.codeChallenge.model.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> getAllStudents();
    Mono<Student> saveStudent(Student student);
}
