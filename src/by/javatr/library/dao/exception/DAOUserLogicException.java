package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOUserLogicException extends DAOException implements Serializable {

    private static final long serialVersionUID = -2157166070963998271L;

    public DAOUserLogicException() {
    }

    public DAOUserLogicException(String message) {
        super(message);
    }

    public DAOUserLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOUserLogicException(Throwable cause) {
        super(cause);
    }
}
