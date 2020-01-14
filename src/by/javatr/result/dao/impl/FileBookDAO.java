package by.javatr.result.dao.impl;

import by.javatr.result.bean.Book;
import by.javatr.result.dao.BookDAO;
import by.javatr.result.exception.dao.DAOBookLogicException;
import by.javatr.result.exception.dao.DAOEmptyDataException;
import by.javatr.result.exception.dao.DAOException;
import by.javatr.result.exception.FileParserException;
import by.javatr.result.exception.ReadFileException;
import by.javatr.result.exception.dao.DAOFileParserException;
import by.javatr.result.parser.ReadFileManager;
import by.javatr.result.parser.WriteFileManager;
import by.javatr.result.validator.BookValidator;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FileBookDAO implements BookDAO {

    private final File FILE = new File("library.jsonl");

    public List<Book> getBookByAuthorSurname(String authorSurname) throws DAOException {

        List<Book> books = getAll();
        if (books == null) {
            throw new DAOEmptyDataException("Book data is empty.");
        }
        List<Book> booksByAuthorSurname = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthorSurname().equalsIgnoreCase(authorSurname)) {
                booksByAuthorSurname.add(book);
            }
        }
        return booksByAuthorSurname;
    }


    @Override
    public List<Book> getAll() throws DAOException {

        List<Book> books = new ArrayList<>();
        Gson gson = new Gson();
        String s = null;

        try {
            List<String> booksStrng = ReadFileManager.readFile(FILE);

            if (booksStrng == null) {
                throw new DAOEmptyDataException("Book data is empty.");
            }
            for (String book : booksStrng) {
                books.add(gson.fromJson(book, Book.class));
            }
        } catch (ReadFileException ex) {
            throw new DAOFileParserException("Reading file caused an error.");
        }

        return books;
    }


    @Override
    public void save(Book book) throws DAOException {

        if (!BookValidator.bookValidator(book)) {
            throw new DAOBookLogicException("Book has incorrect field");
        }
        long id = Math.abs(book.hashCode()) + (System.currentTimeMillis() / 10000);

        while (checkExistUserId(id)) {
            id = Math.abs(book.hashCode()) + (System.currentTimeMillis() / 10000);
        }

        book.setId(id);

        try {
            WriteFileManager.writeToFile(book, FILE, true);
        } catch (FileParserException ex) {
            throw new DAOFileParserException("Writing file caused an error");
        }
    }


    @Override
    public void remove(int id) throws DAOException {

        List<Book> books = getAll();

        if (books != null) {
            Iterator<Book> bookIterator = books.iterator();
            while (bookIterator.hasNext()) {

                if (bookIterator.next().getId() == id) {
                    bookIterator.remove();
                }
            }
            try {
                WriteFileManager.writeToFile(books, FILE);
            } catch (FileParserException ex) {
                throw new DAOFileParserException("Writing file caused an error");
            }
        }
    }

    private boolean checkExistUserId(long id) throws DAOException {
        List<Book> books = getAll();
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
