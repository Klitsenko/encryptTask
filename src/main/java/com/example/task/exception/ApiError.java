package com.example.task.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class ApiError {
    private String message;

    public ApiError() {
    }

    public ApiError(String message) {
        this.message = message;
    }
}
