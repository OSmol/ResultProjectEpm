package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOFileParserException extends DAOException implements Serializable {

    private static final long serialVersionUID = -7378232441139234356L;

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
