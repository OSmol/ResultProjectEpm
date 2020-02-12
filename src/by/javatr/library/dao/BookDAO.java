package by.javatr.library.dao;


import by.javatr.library.dao.exception.DAOException;

import java.awt.print.Book;
import java.util.List;

public interface BookDAO {

    List<Book> getAll() throws DAOException;
    void save(Book book) throws DAOException;
    void remove(int id) throws DAOException;
    List<Book> getBookByAuthorSurname( String authorSurname) throws DAOException;


    }
