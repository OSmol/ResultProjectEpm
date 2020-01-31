package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.service.exception.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;
import java.util.Map;

public class SignOut implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response=new Response();
        response.setStatus(false);
        response.addParameter("SIGN_OUT","true");
        return response;
    }

//todo
    @Override
    public Response execute(Map<String,String> request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            clientService.signOut();
            response=new Response();
            response.addParameter("message","Sign out is successful.");
            response.setStatus(true);

        } catch (ServiceException e) {
            return getUnsuccessfulResponse("Error during sign out procedure");
        }
        return response;
    }
}
