package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceAddBookException extends ServiceException implements Serializable {


    private static final long serialVersionUID = 4846412866777909699L;

    public ServiceAddBookException() {
    }

    public ServiceAddBookException(String message) {
        super(message);
    }

    public ServiceAddBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceAddBookException(Throwable cause) {
        super(cause);
    }
}
