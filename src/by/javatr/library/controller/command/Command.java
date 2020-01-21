package by.javatr.library.controller.command;

import by.javatr.library.util.Response;
import java.util.LinkedHashMap;

public interface Command {

    Response checkParameters();
    Response execute(LinkedHashMap<String, String> parameters);
}
