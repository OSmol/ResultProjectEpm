package by.javatr.library.controller;

import by.javatr.library.controller.command.Command;
import by.javatr.library.controller.command.impl.*;
import by.javatr.library.controller.command.CommandName;
import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.FIND_BOOK,new FindBook());
        repository.put(CommandName.GET_CATALOG, new GetCatalog());
        repository.put(CommandName.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandName.REMOVE_USER,new RemoveUser());
        repository.put(CommandName.GET_USERS,new GetUsers());
        repository.put(CommandName.WRONG_REQUEST,new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

            if(command==null){
                command=repository.get(CommandName.WRONG_REQUEST);
            }

        return command;
    }
}
