package by.javatr.library.exception.view;

public class ImpossibleActionException extends Exception{

    public ImpossibleActionException() {
    }

    public ImpossibleActionException(String message) {
        super(message);
    }

    public ImpossibleActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImpossibleActionException(Throwable cause) {
        super(cause);
    }
}
