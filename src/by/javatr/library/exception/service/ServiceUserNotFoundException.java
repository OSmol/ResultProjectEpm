package by.javatr.library.exception.service;

public class ServiceUserNotFoundException extends ServiceException {


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
