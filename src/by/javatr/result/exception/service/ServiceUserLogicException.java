package by.javatr.result.exception.service;

public class ServiceUserLogicException extends ServiceException {


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
