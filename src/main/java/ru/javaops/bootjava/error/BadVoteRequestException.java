package ru.javaops.bootjava.error;

import org.springframework.http.HttpStatus;

public class BadVoteRequestException extends AppException {
    public BadVoteRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
