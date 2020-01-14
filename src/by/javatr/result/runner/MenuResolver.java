package by.javatr.result.runner;

import by.javatr.result.entity.Status;
import by.javatr.result.bean.User;
import by.javatr.result.entity.*;
import by.javatr.result.exception.NoSuchActionExeption;
import by.javatr.result.exception.service.ServiceException;
import by.javatr.result.exception.view.ImpossibleActionException;
import by.javatr.result.factory.ServiceFactory;
import by.javatr.result.scanner.DataScanner;
import by.javatr.result.service.ClientService;
import by.javatr.result.service.LibraryService;
import by.javatr.result.service.impl.ClientServiceImpl;

public class MenuResolver {

    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ClientService clientService = serviceFactory.getClientService();
    private static LibraryService libraryService = serviceFactory.getLibraryService();

    private static final Menu userMenu = new Menu(2, UserAction.values());
    private static final Menu adminMenu = new Menu(3, AdminAction.values());
    private static final Menu startMenu = new Menu(4, StartAction.values());


    public static Menu getStartMenu() {

        return new Menu(3, StartAction.values());
    }


    public static User registration() throws ImpossibleActionException {

        User user;
        String name;
        String login;
        String password;
        int age;

        System.out.println("Введите имя.");
        name = DataScanner.enterStringFromConsole();
        System.out.println("Введите логин.");
        login = DataScanner.enterStringFromConsole();
        System.out.println("Введите пароль.");
        password = DataScanner.enterStringFromConsole();
        System.out.println("Введите возраст");
        age = DataScanner.enterIntFromConsole();

        try {
            user = clientService.registration(name, login, password, age);
        } catch (ServiceException e) {
            throw new ImpossibleActionException(e.getMessage());
        }

        return user;
    }

    private static User signIn() throws ImpossibleActionException {
        User user;
        String login;
        String password;

        System.out.println("Введите логин.");
        login = DataScanner.enterStringFromConsole();
        System.out.println("Введите пароль.");
        password = DataScanner.enterStringFromConsole();
        try {
            user = clientService.signIn(login, password);
        } catch (ServiceException e) {
            throw new ImpossibleActionException(e.getMessage());
        }
        return user;
    }

    public static void checkAction(int action, User user, Menu menu) {

        int actionInner;
        String someAction;

        try {

            someAction = actionTransformer(action, menu);
            switch (someAction) {
                case "SIGNIN":
                    User loggedUser = MenuResolver.signIn();
                    Printer.printMenu(getFirstMenu(loggedUser));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, loggedUser, getFirstMenu(loggedUser));
                    break;
                case "REGISTRATION":
                    User registratUser = MenuResolver.registration();
                    Printer.printMenu(getFirstMenu(registratUser));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, registratUser, getFirstMenu(registratUser));
                    break;
                case "SIGNOUT":
                    clientService.signOut(user);
                    break;
                case "FINDBOOK":
                    System.out.println("Введите фамилию автора.");
                    String surname;
                    surname = DataScanner.enterStringFromConsole();
                    Printer.printBooks(libraryService.getBookByAuthorSurname(surname), ClientServiceImpl.isAdmin(user));
                    Printer.printMenu(getFirstMenu(user));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, user, menu);
                    break;
                case "GETCATALOG":
                    Printer.printBooks(libraryService.getAllBook(), ClientServiceImpl.isAdmin(user));
                    Printer.printMenu(getFirstMenu(user));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, user, menu);
                    break;
                case "ADDBOOK":

                    System.out.println("Введите имя автора:");
                    String authorName = DataScanner.enterStringFromConsole();

                    System.out.println("Введите фамилию автора:");
                    String authorSurname = DataScanner.enterStringFromConsole();

                    System.out.println("Введите название книги:");
                    String bookName = DataScanner.enterStringFromConsole();

                    System.out.println("Введите год публикации книги:");
                    int year = DataScanner.enterIntFromConsole();

                    System.out.println("Введите краткое описание (450 символов):");
                    String description = DataScanner.enterStringFromConsole();

                    libraryService.addNewBook(authorName, authorSurname, bookName, year, description);
                    Printer.printMenu(getFirstMenu(user));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, user, menu);
                    break;
                case "REMOVEBOOK":
                    Printer.printBooks(libraryService.getAllBook(), ClientServiceImpl.isAdmin(user));
                    Printer.printMenu(getFirstMenu(user));
                    System.out.println("Введите id удаляемой книги:");
                    actionInner = DataScanner.enterIntFromConsole();
                    libraryService.removeBook(actionInner);
                    Printer.printMenu(getFirstMenu(user));
                    actionInner = DataScanner.enterIntFromConsole();
                    checkAction(actionInner, user, menu);
                    break;
                default:
                    break;

            }
        } catch (ServiceException | NoSuchActionExeption |ImpossibleActionException ex) {
            System.out.println("Impossible action.");
        }

    }

    public static Menu getFirstMenu(User user) {

        Menu menu;

        if (!ClientServiceImpl.isOnline(user)) {
            menu = new Menu(1, StartAction.values());
        } else {
            if (ClientServiceImpl.isAdmin(user)) {
                menu = new Menu(3, AdminAction.values());

            } else {
                menu = new Menu(2, UserAction.values());
            }
        }
        return menu;
    }


    private static String actionTransformer(int action, Menu menu) throws NoSuchActionExeption {
        String[] actions = menu.getMenuAction();
        for (int i = 0; i < actions.length; i++) {
            if (i == action) {
                return actions[i];
            }
        }
        throw new NoSuchActionExeption("No such action.");
    }

}






