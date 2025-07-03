package com.example.codeChallenge.repository;

import com.example.codeChallenge.model.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository {

    Mono<Student> findById(Long id);
    Mono<Boolean> findByCode(String code);
    Flux<Student> findAll();
    Mono<Student> save(Student student);
    Mono<Void> deleteById(Long id);
}
