package com.example.codeChallenge.repository.impl;

import com.example.codeChallenge.model.entity.Student;
import com.example.codeChallenge.repository.StudentReactiveRepository;
import com.example.codeChallenge.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentReactiveRepository studentReactiveRepository;

    @Override
    public Mono<Student> findById (Long id) {
        return studentReactiveRepository.findById(id);
    }

    @Override
    public Mono<Boolean> findByCode (String code) {
        return studentReactiveRepository.findByCode(code)
            .map(student -> true)
            .defaultIfEmpty(false);
    }

    @Override
    public Flux<Student> findAll () {
        return studentReactiveRepository.findAllByStatus("active")
            .switchIfEmpty(Flux.error(new RuntimeException("No active students found")));
    }

    @Override
    public Mono<Student> save (Student student) {
        return studentReactiveRepository.save(student);
    }

    @Override
    public Mono<Void> deleteById (Long id) {
        return studentReactiveRepository.deleteById(id);
    }
}
