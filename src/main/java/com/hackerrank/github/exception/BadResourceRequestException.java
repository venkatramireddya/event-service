package com.hackerrank.github.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResourceRequestException extends RuntimeException {
 static final long serialVersionUID = 2321330795556769631L;

	public BadResourceRequestException(String msg) {
        super(msg);
    }
}
