package by.javatr.result.exception.service;

public class ServiceAddBookException extends ServiceException {


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
