package com.domain.handlers;

import com.domain.dto.ResponseData;
import com.domain.exceptions.NotFoundDataException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(value = NotFoundDataException.class)
    public ResponseEntity<ResponseData<String>> notFoundDataException(NotFoundDataException e){
        ResponseData<String> responseData = new ResponseData<>();
        responseData.getMessages().add("Data Not Found");
        responseData.setStatus(false);
        responseData.setPayload(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}
