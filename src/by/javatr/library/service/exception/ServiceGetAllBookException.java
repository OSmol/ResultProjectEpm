package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceGetAllBookException extends ServiceException implements Serializable {


    private static final long serialVersionUID = 6670527358782515306L;

    public ServiceGetAllBookException() {
    }

    public ServiceGetAllBookException(String message) {
        super(message);
    }

    public ServiceGetAllBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGetAllBookException(Throwable cause) {
        super(cause);
    }
}
