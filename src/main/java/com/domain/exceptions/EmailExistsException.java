package com.domain.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException() {
    }

    public EmailExistsException(String arg0) {
        super(arg0);
    }

    public EmailExistsException(Throwable arg0) {
        super(arg0);
    }

    public EmailExistsException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public EmailExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
