package com.example.codeChallenge.exceptions;

import com.example.codeChallenge.util.TechnicalMessage;
import lombok.Getter;


@Getter
public class BusinessException extends ProcessorException {

    public BusinessException(TechnicalMessage technicalMessage) {
        super(technicalMessage.getMessage(), technicalMessage);
    }
}
