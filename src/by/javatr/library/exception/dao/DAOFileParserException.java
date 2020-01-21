package by.javatr.library.exception.dao;

public class DAOFileParserException extends DAOException{

    public DAOFileParserException() {
    }

    public DAOFileParserException(String message) {
        super(message);
    }

    public DAOFileParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOFileParserException(Throwable cause) {
        super(cause);
    }
}
