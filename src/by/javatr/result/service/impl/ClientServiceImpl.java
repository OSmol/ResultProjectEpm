package by.javatr.result.service.impl;

import by.javatr.result.util.Role;
import by.javatr.result.util.Status;
import by.javatr.result.bean.User;
import by.javatr.result.dao.UserDAO;
import by.javatr.result.exception.dao.DAOException;
import by.javatr.result.exception.service.*;
import by.javatr.result.factory.DAOFactory;
import by.javatr.result.service.ClientService;
import by.javatr.result.validator.UserValidator;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = daoFactory.getUserDAO();


    @Override
    public User signIn(String login, String password) throws ServiceException {

        if (!UserValidator.validateLogin(login)) {
            throw new ServiceUserLogicException("Login is incorrect");
        }

        if (!UserValidator.validatePassword(password)) {
            throw new ServiceUserLogicException("Password is incorrect");
        }

        User user;

        try {
            user = userDAO.getUserByLogin(login);
            if (user != null && user.getPassword().equals(password)) {
                user.setStatus(Status.ONLINE);
                return user;
            } else {
                throw new ServiceUserNotFoundException("Such user doesn't exist. Or password is incorrect.");
            }
        } catch (DAOException e) {
            throw new ServiceUserNotFoundException("Such user doesn't exist. Or password is incorrect.");
        }
    }

    @Override
    public void signOut(User user) {

        if (user.getStatus().equals(Status.ONLINE)) {
            user.setStatus(Status.OFFLINE);
        }
    }

    @Override
    public User registration(String name, String login, String password, int year) throws ServiceException {

        if (!UserValidator.validateLogin(login)) {
            throw new ServiceUserLogicException("Login is incorrect");
        }

        if (!UserValidator.validatePassword(password)) {
            throw new ServiceUserLogicException("Password is incorrect");
        }

        if (!UserValidator.validateName(name)) {
            throw new ServiceUserLogicException("Name is incorrect");
        }

        if (!UserValidator.validateYear(year)) {
            throw new ServiceUserLogicException("Year is incorrect");

        }
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setYear(year);
        user.setRole(Role.USER);
        try {
            userDAO.save(user);
            user.setStatus(Status.ONLINE);
            return user;
        } catch (DAOException e) {
            throw new ServiceFileWriteException("Writing file caused an error.");
        }
    }

    @Override
    public void removeUser(int id) throws ServiceException {
        try {
            userDAO.removeUserById(id);
        } catch (DAOException e) {
            throw new ServiceRemoveBookException("Impossible to remove.");
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException{
        try {
            return userDAO.getAll();
        } catch (DAOException e) {
          throw new ServiceEmptyDataException("Empty data.");
        }
    }

    public static boolean isAdmin(User user) {
        if (user != null && user.getRole() == Role.ADMIN) {
            return true;
        }
        return false;
    }

    public static boolean isOnline(User user) {
        if (user != null && user.getStatus() == Status.ONLINE) {
            return true;
        }
        return false;
    }
}
