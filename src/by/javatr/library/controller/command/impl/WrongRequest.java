package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.util.Response;
import java.util.LinkedHashMap;

public class WrongRequest implements Command {

    Response response;

    @Override
    public Response checkParameters() {
        response=new Response();
        response.setStatus(false);
        return response;
    }

    @Override
    public Response execute(LinkedHashMap<String, String> parameters) {
        response=new Response();
        response.addParameter("message","Your request doesn't exist.");
        response.setStatus(true);
        return response;

    }
}
