package by.javatr.library.dao.exception;

public class DAOBookLogicException extends DAOException{

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
