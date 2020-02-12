package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceGetBookByAuthorSurnameException extends ServiceException implements Serializable {


    private static final long serialVersionUID = 6047426967979324269L;

    public ServiceGetBookByAuthorSurnameException() {
    }

    public ServiceGetBookByAuthorSurnameException(String message) {
        super(message);
    }

    public ServiceGetBookByAuthorSurnameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGetBookByAuthorSurnameException(Throwable cause) {
        super(cause);
    }
}
