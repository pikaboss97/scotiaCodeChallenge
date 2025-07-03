package com.example.codeChallenge.controller.handler;

import com.example.codeChallenge.controller.exceptions.HandleError;
import com.example.codeChallenge.controller.mapper.StudentMapper;
import com.example.codeChallenge.model.dto.StudentDTO;
import com.example.codeChallenge.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class StudentHandler {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public Mono<ServerResponse> createStudent (ServerRequest request) {
        String messageId = getMessageId(request);
        return request.bodyToMono(StudentDTO.class)
            .flatMap(student -> studentService.saveStudent(studentMapper.studentDTOToStudent(student))
                .doOnSuccess(savedStudent -> log.info("Student created successfully with code: {}", savedStudent.getCode()))
            )
            .flatMap(savedUser -> ServerResponse.status(HttpStatus.CREATED).bodyValue(""))
            .contextWrite(Context.of("x-message-id", messageId))
            .doOnError(ex -> log.error("Error on create student - [ERROR] [{}]", ex.getMessage()))
            .onErrorResume(ex -> HandleError.handleError(ex, messageId));
    }

    public Mono<ServerResponse> getAllStudents(ServerRequest request) {
        String messageId = getMessageId(request);
        return studentService.getAllStudents()
            .collectList()
            .flatMap(users -> ServerResponse.ok().bodyValue(users))
            .contextWrite(Context.of("x-message-id", messageId))
            .doOnError(ex -> log.error("Error on get all students - [ERROR] [{}]", ex.getMessage()))
            .onErrorResume(ex -> HandleError.handleError(ex, messageId));
    }

    private String getMessageId (ServerRequest serverRequest) {
        return serverRequest.headers().firstHeader("x-message-id") != null
            ? serverRequest.headers().firstHeader("x-message-id")
            : UUID.randomUUID().toString();
    }
}
