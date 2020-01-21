package by.javatr.library.exception.service;

public class ServiceEmptyDataException extends ServiceException {


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
