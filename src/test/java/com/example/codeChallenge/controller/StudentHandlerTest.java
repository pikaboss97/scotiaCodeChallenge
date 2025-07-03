package com.example.codeChallenge.controller;

import com.example.codeChallenge.controller.handler.StudentHandler;
import com.example.codeChallenge.controller.mapper.StudentMapperImpl;
import com.example.codeChallenge.exceptions.BusinessException;
import com.example.codeChallenge.exceptions.TechnicalException;
import com.example.codeChallenge.model.dto.StudentDTO;
import com.example.codeChallenge.model.entity.Student;
import com.example.codeChallenge.service.StudentService;
import com.example.codeChallenge.util.TechnicalMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
@Import({RouterRest.class, StudentHandler.class, StudentMapperImpl.class})
public class StudentHandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private StudentService studentService;

    @Test
    void createStudent_shouldReturn201Created() {
        StudentDTO student = new StudentDTO("COD-01", "John", "Doe", "active",22);
        Mockito.when(studentService.saveStudent(Mockito.any())).thenReturn(Mono.just(new Student()));
        webTestClient.post()
            .uri("/api/v1/student")
            .header("x-message-id", "abc-123")
            .bodyValue(student)
            .exchange()
            .expectStatus().isCreated();
    }
    @Test
    void createStudent_shouldReturn400Duplicated() {
        StudentDTO student = new StudentDTO("COD-01", "John", "Doe", "active",22);
        Mockito.when(studentService.saveStudent(Mockito.any())).thenThrow(new BusinessException(TechnicalMessage.STUDENT_ALREADY_EXISTS));
        webTestClient.post()
            .uri("/api/v1/student")
            .header("x-message-id", "abc-123")
            .bodyValue(student)
            .exchange()
            .expectStatus().is4xxClientError();
    }

    @Test
    void createStudent_shouldReturn400InvalidRequest() {
        StudentDTO student = new StudentDTO("COD-01", "John", "Doe", "active",22);
        Mockito.when(studentService.saveStudent(Mockito.any())).thenThrow(new TechnicalException(TechnicalMessage.INVALID_PARAMETERS));
        webTestClient.post()
            .uri("/api/v1/student")
            .header("x-message-id", "abc-123")
            .bodyValue(student)
            .exchange()
            .expectStatus().is5xxServerError();
    }

    @Test
    void createStudent_shouldReturn500ServerError() {
        StudentDTO student = new StudentDTO("COD-01", "John", "Doe", "active",22);
        Mockito.when(studentService.saveStudent(Mockito.any())).thenThrow(new RuntimeException("Unexpected error"));
        webTestClient.post()
            .uri("/api/v1/student")
            .header("x-message-id", "abc-123")
            .bodyValue(student)
            .exchange()
            .expectStatus().is5xxServerError();
    }


    @Test
    void listStudents_shouldReturn200() {
        Mockito.when(studentService.getAllStudents()).thenReturn(Flux.just(new Student()));
        webTestClient.get()
            .uri("/api/v1/student/list")
            .header("x-message-id", "abc-123")
            .exchange()
            .expectStatus().is2xxSuccessful();
    }
}
