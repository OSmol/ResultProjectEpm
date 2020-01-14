package by.javatr.result.dao;


import by.javatr.result.bean.Book;
import by.javatr.result.exception.dao.DAOException;

import java.util.List;

public interface BookDAO {

    List<Book> getAll() throws DAOException;
    void save(Book book) throws DAOException;
    void remove(int id) throws DAOException;
    List<Book> getBookByAuthorSurname( String authorSurname) throws DAOException;


    }
