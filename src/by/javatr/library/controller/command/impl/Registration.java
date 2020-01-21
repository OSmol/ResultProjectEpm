package by.javatr.library.controller.command.impl;

import by.javatr.library.bean.User;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;

import java.util.LinkedHashMap;

public class Registration implements Command {

    private Response response;

    @Override
    public Response checkParameters() {
        response = new Response();
        response.addParameter("name",null);
        response.addParameter("login",null );
        response.addParameter("password",null);
        response.addParameter("year",null);
        response.setStatus(true);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String, String> request) {
        String name = request.get("name");
        String login = request.get("login");
        String password = request.get("password");
        int year = Integer.parseInt(request.get("year"));
        response = new Response();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            User user = clientService.registration(name, login, password, year);
            response.addParameter("message", "Welcome to our library!");
            response.addParameter("userId", String.valueOf(user.getId()));
            response.setStatus(true);



        } catch (ServiceException e) {
            response.addParameter("message", "Error during registration procedure");
        }
        return response;
    }
}
