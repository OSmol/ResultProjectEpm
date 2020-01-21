package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.LibraryService;
import by.javatr.library.util.Response;
import by.javatr.library.util.action.CommandName;

import java.util.LinkedHashMap;

public class RemoveBook implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response=new Response();
        response.addParameter("id",null);
        response.setCommandName(CommandName.GET_CATALOG.toString());
        response.setStatus(true);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String,String> request) {
        int id = Integer.parseInt(request.get("id"));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        try {
            response=new Response();
            libraryService.removeBook(id);
            response.addParameter("message","Book is removed.");
            response.setStatus(true);

        } catch (ServiceException e) {
            response = new Response();
            response.addParameter("message","Error during remove book procedure");
            response.setStatus(false);
        }
        return response;
    }
}
