package by.javatr.library.controller.command.impl;

import by.javatr.library.bean.User;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;
import java.util.LinkedHashMap;

public class SignIn implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response = new Response();
        response.setStatus(true);
        response.addParameter("login", null);
        response.addParameter("password", null);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String, String> parameters) {
        String login = parameters.get("login");
        String password = parameters.get("password");
        Response response=new Response();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            User user=clientService.signIn(login, password);
            response.setStatus(true);
            response.addParameter("message", "Welcome!");
            response.addParameter("userId",String.valueOf(user.getId()));

        } catch (ServiceException e) {
            response.setStatus(false);
            response.addParameter("message","Error during login procedure");
        }
        return response;
    }

}
