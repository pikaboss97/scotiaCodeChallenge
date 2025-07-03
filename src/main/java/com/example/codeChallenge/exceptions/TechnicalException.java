package com.example.codeChallenge.exceptions;

import com.example.codeChallenge.util.TechnicalMessage;
import lombok.Getter;

@Getter
public class TechnicalException extends ProcessorException {

    public TechnicalException(Throwable cause, TechnicalMessage technicalMessage) {
        super(cause, technicalMessage);
    }

    public TechnicalException(TechnicalMessage technicalMessage) {
        super(technicalMessage.getMessage(), technicalMessage);
    }
}