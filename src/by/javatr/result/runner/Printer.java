package by.javatr.result.runner;

import by.javatr.result.bean.Book;
import by.javatr.result.bean.User;
import by.javatr.result.util.Menu;

import java.util.List;


public class Printer {


    private static MenuResolver menuService = new MenuResolver();


    public static void printMenu(Menu menu) {
        String[] actions = menu.getMenuAction();
        printHeadOfMenu();

        for (int i = 0; i < actions.length; i++) {
            System.out.printf("|%-7s|%-27s|\n", i, actions[i]);
        }

    }

    private static void printHeadOfMenu() {
        System.out.println("-------------------------------------");
        System.out.printf("|%-7s|%-27s|\n", "Число", "Действие");
        System.out.println("-------------------------------------");

    }


    public static void printBooks(List<Book> list, boolean isAdmin) {
        for (Book book : list) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (isAdmin) {
                System.out.println("id: "+book.getId());
            }
            System.out.print("author name: "+book.getAuthorName() + " ");
            System.out.println("author surname: "+book.getAuthorSurname());
            System.out.println("book year: "+book.getYear());
            System.out.println("book name: "+book.getBookName());
            System.out.println("description: \n"+book.getDescription() + "\n");

        }
    }

    public static void printUsers(List<User> list) {
        for (User user : list) {
            System.out.println("id: "+user.getId());
            System.out.println("name: "+user.getName() + " ");
            System.out.println("login: "+user.getLogin());
            System.out.println("year: "+user.getYear());
            System.out.println("status: "+user.getStatus());
            System.out.println("role: "+user.getRole() + "\n");

        }
    }
}


