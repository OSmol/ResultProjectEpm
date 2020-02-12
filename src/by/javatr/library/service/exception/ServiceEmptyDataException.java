package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceEmptyDataException extends ServiceException implements Serializable {


    private static final long serialVersionUID = -1914473833829376547L;

    public ServiceEmptyDataException() {
    }

    public ServiceEmptyDataException(String message) {
        super(message);
    }

    public ServiceEmptyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceEmptyDataException(Throwable cause) {
        super(cause);
    }
}
