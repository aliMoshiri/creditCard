package com.creditcard.exceptions;

import org.springframework.validation.Errors;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public class InvalidRequestException extends RuntimeException {
    private static final long serialVersionUID = -589229703599785149L;
    private Errors            errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}