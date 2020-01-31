package by.javatr.library.service.exception;

public class ServiceBookLogicException extends ServiceException{

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
