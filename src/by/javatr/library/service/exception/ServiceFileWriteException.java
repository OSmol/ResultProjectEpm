package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceFileWriteException extends ServiceException implements Serializable {


    private static final long serialVersionUID = 6414581890703848730L;

    public ServiceFileWriteException() {
    }

    public ServiceFileWriteException(String message) {
        super(message);
    }

    public ServiceFileWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceFileWriteException(Throwable cause) {
        super(cause);
    }
}
