package by.javatr.library.dao.exception;

public class DAOEmptyDataException extends DAOException{

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