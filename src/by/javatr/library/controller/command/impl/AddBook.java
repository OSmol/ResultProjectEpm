package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.LibraryService;
import by.javatr.library.util.Response;
import java.util.LinkedHashMap;

public class AddBook implements Command {


    Response response;

    @Override
    public Response checkParameters() {
        response = new Response();
        response.setStatus(true);
        response.addParameter("bookName", null);
        response.addParameter("authorName", null);
        response.addParameter("authorSurname", null);
        response.addParameter("year", null);
        response.addParameter("description", null);
        response.setStatus(true);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String, String> request) {
        String bookName = request.get("bookName");
        String authorName = request.get("authorName");
        String authorSurname = request.get("authorSurname");
        int year = Integer.parseInt(request.get("year"));
        String description = request.get("description");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        try {
            libraryService.addNewBook(authorName, authorSurname, bookName, year, description);
            response = new Response();
            response.addParameter("message", "Book was added!");
            response.setStatus(true);

        } catch (ServiceException e) {

            response.addParameter("message", "Error during add book procedure");
            response.setStatus(false);
        }
        return response;
    }
}
