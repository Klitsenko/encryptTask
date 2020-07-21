package com.example.task.exception;

public class RequestExecutionException extends RuntimeException {
    public RequestExecutionException(String message) {
        super(message);
    }
}
