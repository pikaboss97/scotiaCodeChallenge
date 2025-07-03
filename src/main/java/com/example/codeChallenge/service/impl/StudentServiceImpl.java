package com.example.codeChallenge.service.impl;

import com.example.codeChallenge.exceptions.BusinessException;
import com.example.codeChallenge.model.entity.Student;
import com.example.codeChallenge.repository.StudentRepository;
import com.example.codeChallenge.service.StudentService;
import com.example.codeChallenge.util.TechnicalMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Flux<Student> getAllStudents () {
        return studentRepository.findAll()
            .doOnNext(response -> log.info("Get active students successfully"))
            .doOnError(error -> log.error("Error getting active students {}", error.getMessage()))
            .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Student> saveStudent (Student student) {
        return studentRepository.findByCode(student.getCode())
            .filter(exists -> !exists)
            .switchIfEmpty(Mono.error(new BusinessException(TechnicalMessage.STUDENT_ALREADY_EXISTS)))
            .flatMap(data -> studentRepository.save(student))
            .onErrorResume(Mono::error);
    }
}
