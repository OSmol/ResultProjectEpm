package by.javatr.library.service.exception;

import java.io.Serializable;

public class ServiceBookLogicException extends ServiceException implements Serializable {

    private static final long serialVersionUID = -5590891009830767041L;

    public ServiceBookLogicException() {
    }

    public ServiceBookLogicException(String message) {
        super(message);
    }

    public ServiceBookLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceBookLogicException(Throwable cause) {
        super(cause);
    }
}
