package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOException extends Exception implements Serializable {

    private static final long serialVersionUID = -5507399064231052499L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
