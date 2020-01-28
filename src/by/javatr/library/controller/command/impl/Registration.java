package by.javatr.library.controller.command.impl;

import by.javatr.library.bean.User;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;
import java.util.Map;

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
    public Response execute(Map<String, String> request) {
        String name = request.get("name");
        String login = request.get("login");
        String password = request.get("password");

        int year = 0;
        response = new Response();
        try {
            year = Integer.parseInt(request.get("year"));
        } catch (NumberFormatException ex) {
            return getUnsuccessfulResponse("Year is invalid.");
        }

        response = new Response();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            User user = clientService.registration(name, login, password, year);
            response.addParameter("message", "Welcome to our library!");
            response.addParameter("userId", String.valueOf(user.getId()));
            response.setStatus(true);

        } catch (ServiceException e) {
            return getUnsuccessfulResponse("Error during registration procedure");
        }
        return response;
    }
}
