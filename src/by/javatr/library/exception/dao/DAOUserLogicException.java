package by.javatr.library.exception.dao;

public class DAOUserLogicException extends DAOException{

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
