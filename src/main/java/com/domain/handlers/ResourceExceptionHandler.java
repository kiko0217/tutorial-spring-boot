package com.domain.handlers;

import com.domain.dto.ResponseData;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseData<String>> dataIntegrityViolationException(DataIntegrityViolationException e){
        ResponseData<String> responseData = new ResponseData<>();
        responseData.getMessages().add("Data Integrity Violation Exception");
        responseData.setStatus(false);
        responseData.setPayload(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

}
