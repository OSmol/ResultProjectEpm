package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;
import by.javatr.library.util.action.CommandName;
import java.util.Map;

public class RemoveUser implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response=new Response();
        response.addParameter("id", null);
        response.setCommandName(CommandName.GET_USERS.toString());
        response.setStatus(true);
        return response;
    }

    @Override
    public Response execute(Map<String,String> request){
        int id=0;
        response = new Response();
        try {
            id = Integer.parseInt(request.get("id"));
        } catch (NumberFormatException ex) {
            return getUnsuccessfulResponse("We wasn't able to remove user with such id.");
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            clientService.removeUser(id);
            response=new Response();
            response.addParameter("message","User was removed.");
            response.setStatus(true);

        } catch (ServiceException e) {
            return getUnsuccessfulResponse("We wasn't able to remove user.");
        }
        return null;
    }

  }
