package by.javatr.result.service.impl;

import by.javatr.result.bean.Book;
import by.javatr.result.dao.BookDAO;
import by.javatr.result.exception.dao.DAOException;
import by.javatr.result.exception.service.*;
import by.javatr.result.factory.DAOFactory;
import by.javatr.result.service.LibraryService;
import by.javatr.result.validator.BookValidator;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    BookDAO bookDAO = daoFactory.getBookDAO();

    @Override
    public void addNewBook(String authorName, String authorSurname, String bookName, int year, String description) throws ServiceException {

        if(!BookValidator.validateAuthorName(authorName)&&
                !BookValidator.validateAuthorName(authorSurname)){
            throw new ServiceBookLogicException("Author name is incorrect.");
        }

        if(!BookValidator.validateBookName(bookName)){
            throw new ServiceBookLogicException("Book name is incorrect.");
        }

        if(!BookValidator.validateBookYear(year)){
            throw new ServiceBookLogicException("Book year is incorrect.");
        }

        if(!BookValidator.validateDescription(description)){
            throw new ServiceBookLogicException("Description is too large.");
        }

        Book book = new Book();
        book.setAuthorName(authorName);
        book.setAuthorSurname(authorSurname);
        book.setBookName(bookName);
        book.setYear(year);
        book.setDescription(description);

        try {
            bookDAO.save(book);
        } catch (DAOException ex) {
            throw new ServiceAddBookException("Impossible to add.");
        }

    }

    @Override
    public List<Book> getAllBook() throws ServiceException {

        try {
            return bookDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceGetAllBookException("Impossible action");
        }
    }

    @Override
    public List<Book> getBookByAuthorSurname(String surname) throws ServiceException {
        List<Book> books;
        try {
            books=bookDAO.getBookByAuthorSurname(surname);
            if(books==null){
              throw new ServiceEmptyDataException("Empty data");
            }

        } catch (DAOException ex) {
            throw new ServiceGetBookByAuthorSurnameException("Impossible to get data");
        }
        return books;
    }

    @Override
    public void removeBook(int id) throws ServiceException {

        try {
            bookDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceRemoveBookException("Impossible to remove.");
        }
    }
}
