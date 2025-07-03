package com.example.codeChallenge.service;

import com.example.codeChallenge.model.entity.Student;
import com.example.codeChallenge.repository.StudentRepository;
import com.example.codeChallenge.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

public class StudentServiceImplTest {


    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return active students list")
    public void shouldReturnStudentsList () {
        Mockito.when(studentRepository.findAll()).thenReturn(Flux.just(new Student()));
        StepVerifier.create(studentService.getAllStudents())
            .expectNextMatches(Objects::nonNull)
            .verifyComplete();
    }

    @Test
    @DisplayName("Should save new and unique student")
    public void shouldReturnSuccessfullySaved () {
        Mockito.when(studentRepository.findByCode(Mockito.any())).thenReturn(Mono.just(false));
        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(Mono.just(new Student()));
        StepVerifier.create(studentService.saveStudent(new Student()))
            .expectNextMatches(Objects::nonNull)
            .verifyComplete();
    }
}
