package com.domain.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;


public class ErrorParsingUtility {
    private ErrorParsingUtility() {
        throw new IllegalStateException("Error Parsing Utility class");
    }

    public static List<String> parse(Errors errors){
        List<String> messages = new ArrayList<>();
        for(ObjectError error: errors.getAllErrors()){
            messages.add(error.getDefaultMessage());
        }
        return messages;
    }
}
