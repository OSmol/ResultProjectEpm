package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOEmptyDataException extends DAOException implements Serializable {

    private static final long serialVersionUID = -2611656547777572323L;

    public DAOEmptyDataException() {
    }

    public DAOEmptyDataException(String message) {
        super(message);
    }

    public DAOEmptyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOEmptyDataException(Throwable cause) {
        super(cause);
    }
}
