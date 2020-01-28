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

public class GetCatalog implements Command {

    Response response;
    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ClientService clientService = serviceFactory.getClientService();

    @Override
    public Response checkParameters() {
        response=new Response();
        response.setStatus(false);
        return response;
    }

    @Override
    public Response execute(Map<String,String> request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService=serviceFactory.getLibraryService();
        try {
            response=new Response();
            List<Book> allBook = libraryService.getAllBook();
            StringBuilder booksToString=new StringBuilder();
            booksToString.append("~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            for(Book book:allBook){
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
           return getUnsuccessfulResponse("We wasn't able to show catalog now. Try again a little bit later.");
        }
        return response;
    }
}
