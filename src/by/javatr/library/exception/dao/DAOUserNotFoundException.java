package by.javatr.library.exception.dao;

public class DAOUserNotFoundException extends DAOException{

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
