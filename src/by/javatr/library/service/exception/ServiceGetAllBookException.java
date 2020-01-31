package by.javatr.library.service.exception;

public class ServiceGetAllBookException extends ServiceException {


    public ServiceGetAllBookException() {
    }

    public ServiceGetAllBookException(String message) {
        super(message);
    }

    public ServiceGetAllBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGetAllBookException(Throwable cause) {
        super(cause);
    }
}
