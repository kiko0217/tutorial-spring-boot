package com.domain.exceptions;

public class NotFoundDataException extends RuntimeException {

    public NotFoundDataException() {
    }

    public NotFoundDataException(String arg0) {
        super(arg0);
    }

    public NotFoundDataException(Throwable arg0) {
        super(arg0);
    }

    public NotFoundDataException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NotFoundDataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
        
}
