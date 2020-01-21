package by.javatr.library.controller.command.impl;

import by.javatr.library.bean.User;
import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.factory.ServiceFactory;
import by.javatr.library.service.ClientService;
import by.javatr.library.util.Response;
import java.util.LinkedHashMap;
import java.util.List;

public class GetUsers implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response=new Response();
        response.setStatus(false);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String,String> request){

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            List<User> allUsers = clientService.getAllUsers();

            StringBuilder usersToString=new StringBuilder();
            usersToString.append("~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            for (User user : allUsers) {
                usersToString.append("id: ").append(user.getId()).append("\n");
                usersToString.append("name: ").append(user.getName()).append(" \n");
                usersToString.append("login: ").append(user.getLogin()).append("\n");
                usersToString.append("year: ").append(user.getYear()).append("\n");
                usersToString.append("status: ").append(user.getStatus()).append("\n");
                usersToString.append("role: ").append(user.getRole()).append("\n");
                usersToString.append("~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            }

            response=new Response();
            response.addParameter("message",usersToString.toString());
            response.setStatus(true);

        } catch (ServiceException e) {
            response=new Response();
            response.addParameter("message","Error during get users procedure");
            response.setStatus(false);
        }
        return response;
    }
}
