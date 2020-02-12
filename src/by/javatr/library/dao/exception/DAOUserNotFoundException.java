package by.javatr.library.dao.exception;

import java.io.Serializable;

public class DAOUserNotFoundException extends DAOException implements Serializable {

    private static final long serialVersionUID = 5134213219321323794L;

    public DAOUserNotFoundException() {
    }

    public DAOUserNotFoundException(String message) {
        super(message);
    }

    public DAOUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOUserNotFoundException(Throwable cause) {
        super(cause);
    }
}
