package by.javatr.library.service;

import by.javatr.library.bean.Book;
import by.javatr.library.exception.service.ServiceException;

import java.util.List;

public interface LibraryService {

    void addNewBook(String authorName, String authorSurname, String bookName, int year, String description) throws ServiceException;

    List<Book> getBookByAuthorSurname(String surname) throws ServiceException;

    void removeBook(int id)throws ServiceException;

    List<Book> getAllBook()throws ServiceException;

}
