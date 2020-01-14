package by.javatr.result.factory;


import by.javatr.result.dao.BookDAO;
import by.javatr.result.dao.UserDAO;
import by.javatr.result.dao.impl.FileBookDAO;
import by.javatr.result.dao.impl.FileUserDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO fileUserImpl = new FileUserDAO();
    private final BookDAO fileBookImpl = new FileBookDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }

    public BookDAO getBookDAO() {
        return fileBookImpl;
    }
}
