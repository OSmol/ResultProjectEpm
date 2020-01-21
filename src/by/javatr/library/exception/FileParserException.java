package by.javatr.library.exception;

public class FileParserException extends Exception{

    public FileParserException() {
    }

    public FileParserException(String message) {
        super(message);
    }

    public FileParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileParserException(Throwable cause) {
        super(cause);
    }
}
