package ru.mbkcapital.error;

import org.springframework.validation.Errors;

/**
 * Created by orbot on 08.03.16.
 */
public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
