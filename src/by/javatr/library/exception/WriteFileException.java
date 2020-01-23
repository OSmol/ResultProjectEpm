package by.javatr.library.exception;

public class WriteFileException extends Exception{

    public WriteFileException() {
    }

    public WriteFileException(String message) {
        super(message);
    }

    public WriteFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteFileException(Throwable cause) {
        super(cause);
    }
}
