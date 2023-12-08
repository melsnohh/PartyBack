package com.techelevator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenMissingException extends RuntimeException {

    public TokenMissingException() {
        super("Missing Spotify token.");
    }
}
