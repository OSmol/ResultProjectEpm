package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceRemoveBookException extends ServiceException implements Serializable {


    private static final long serialVersionUID = -6733707073355067068L;

    public ServiceRemoveBookException() {
    }

    public ServiceRemoveBookException(String message) {
        super(message);
    }

    public ServiceRemoveBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceRemoveBookException(Throwable cause) {
        super(cause);
    }
}
