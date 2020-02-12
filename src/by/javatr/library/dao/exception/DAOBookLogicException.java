package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOBookLogicException extends DAOException implements Serializable {

    private static final long serialVersionUID = 8543088277479378937L;

    public DAOBookLogicException() {
    }

    public DAOBookLogicException(String message) {
        super(message);
    }

    public DAOBookLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOBookLogicException(Throwable cause) {
        super(cause);
    }
}
