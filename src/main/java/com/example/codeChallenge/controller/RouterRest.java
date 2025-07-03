package com.example.codeChallenge.controller;

import com.example.codeChallenge.controller.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction (StudentHandler studentHandler) {
        return route(GET("/api/v1/student/list"), studentHandler::getAllUsers)
            .andRoute(POST("/api/v1/student"), studentHandler::createUser);
    }
}
