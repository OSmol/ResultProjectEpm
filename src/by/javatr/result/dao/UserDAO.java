package by.javatr.result.dao;

import by.javatr.result.bean.User;
import by.javatr.result.exception.dao.DAOException;

import java.util.List;

public interface UserDAO {

    List<User> getAll() throws DAOException;

    void save(User user) throws DAOException;

    //todo
  //  void update(User user) throws DAOException;

    void delete(User user) throws DAOException;

    User getUserByLogin(String login) throws DAOException;


}
