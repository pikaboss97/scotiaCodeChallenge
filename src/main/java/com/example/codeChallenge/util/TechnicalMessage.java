package com.example.codeChallenge.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TechnicalMessage {

    INTERNAL_ERROR("500", "Something went wrong, please try again", ""),
    INVALID_REQUEST("400", "Bad Request, please verify data", ""),
    INVALID_PARAMETERS(INVALID_REQUEST.getCode(), "Bad Parameters, please verify data", ""),
    STUDENT_ALREADY_EXISTS("400", "The Student is already registered.", "");

    private final String code;
    private final String message;
    private final String param;
}