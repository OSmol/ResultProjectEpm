package by.javatr.library.controller.command.impl;

import by.javatr.library.bean.Book;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.service.LibraryService;
import by.javatr.library.util.Response;
import by.javatr.library.util.Role;
import java.util.List;
import java.util.Map;

public class FindBook implements Command {

    Response response;

    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ClientService clientService = serviceFactory.getClientService();

    @Override
    public Response checkParameters() {
        response=new Response();
        response.addParameter("authorSurname",null);
        response.setStatus(true);
        return response;
    }

    @Override
    public Response execute(Map<String,String> request) {

        String authorSurname =request.get("authorSurname");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        try {
            response=new Response();
            List<Book> bookByAuthorSurname = libraryService.getBookByAuthorSurname(authorSurname);
            StringBuilder booksToString=new StringBuilder();
            booksToString.append("~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            for(Book book:bookByAuthorSurname){
                if (clientService.getAuthorizedUser().getRole()== Role.ADMIN) {
                    booksToString.append("id: ").append(book.getId()).append("\n");
                }
                booksToString.append("author name: ").append(book.getAuthorName()).append(" \n");
                booksToString.append("author surname: ").append(book.getAuthorSurname()).append(" \n");
                booksToString.append("book year: ").append(book.getYear()).append(" \n");
                booksToString.append("book name: ").append(book.getBookName()).append(" \n");
                booksToString.append("description: \n").append(book.getDescription()).append("\n");
                booksToString.append("~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            }

            response.addParameter("message",booksToString.toString());
            response.setStatus(true);

        } catch (ServiceException e) {
          return getUnsuccessfulResponse("We wasn't able to find the book.");
        }
        return response;
    }
}
