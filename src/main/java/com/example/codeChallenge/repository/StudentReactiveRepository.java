package com.example.codeChallenge.repository;

import com.example.codeChallenge.model.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentReactiveRepository extends ReactiveCrudRepository<Student, Long> {

    Mono<Student> findByCode (String code);

    Flux<Student> findAllByStatus (String status);
}
