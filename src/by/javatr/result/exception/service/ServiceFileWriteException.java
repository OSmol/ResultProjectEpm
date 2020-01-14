package by.javatr.result.exception.service;

public class ServiceFileWriteException extends ServiceException {


    public ServiceFileWriteException() {
    }

    public ServiceFileWriteException(String message) {
        super(message);
    }

    public ServiceFileWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceFileWriteException(Throwable cause) {
        super(cause);
    }
}
