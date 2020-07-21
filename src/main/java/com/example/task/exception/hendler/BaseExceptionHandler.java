package com.example.task.exception.hendler;

import com.example.task.exception.*;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {
    private static Logger LOG = Logger.getLogger(BaseExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(DecryptorException.class)
    public ResponseEntity<ApiError> decryptorException(DecryptorException e) {
        LOG.error("Decryptor exception ", e);
        return ResponseEntity.status(500)
                .body(new ApiError(e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(EncryptorException.class)
    public ResponseEntity<ApiError> encryptorException(EncryptorException e) {
        LOG.error("Encryptor exception ", e);
        return ResponseEntity.status(500)
                .body(new ApiError(e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(RequestExecutionException.class)
    public ResponseEntity<ApiError> requestExecutionException(RequestExecutionException e) {
        LOG.error("Request execution exception ", e);
        return ResponseEntity.status(500)
                .body(new ApiError(e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> userNotFoundException(UserNotFoundException e) {
        LOG.error("User not found exception", e);
        return ResponseEntity.status(500)
                .body(new ApiError(e.getMessage()));
    }
}
