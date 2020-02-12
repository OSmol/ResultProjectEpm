package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceUserLogicException extends ServiceException implements Serializable {


    private static final long serialVersionUID = 7516716884582149568L;

    public ServiceUserLogicException() {
    }

    public ServiceUserLogicException(String message) {
        super(message);
    }

    public ServiceUserLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserLogicException(Throwable cause) {
        super(cause);
    }
}
