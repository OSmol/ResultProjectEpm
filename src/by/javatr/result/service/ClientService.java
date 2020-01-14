package by.javatr.result.service;

import by.javatr.result.bean.User;
import by.javatr.result.exception.service.ServiceException;

public interface ClientService {

    User signIn(String login, String password) throws ServiceException;
    void signOut(User user) throws ServiceException;
    User registration(String name, String login, String password, int age) throws ServiceException;

}
