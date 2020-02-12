package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceUserNotFoundException extends ServiceException implements Serializable {


    private static final long serialVersionUID = -8481991095164029948L;

    public ServiceUserNotFoundException() {
    }

    public ServiceUserNotFoundException(String message) {
        super(message);
    }

    public ServiceUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserNotFoundException(Throwable cause) {
        super(cause);
    }
}
