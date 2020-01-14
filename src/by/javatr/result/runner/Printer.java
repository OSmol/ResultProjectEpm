package by.javatr.result.runner;

import by.javatr.result.bean.Book;
import by.javatr.result.entity.Menu;

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
            if (isAdmin) {
                System.out.println(book.getId());
            }
            System.out.print(book.getAuthorName() + " ");
            System.out.println(book.getAuthorSurname());
            System.out.println(book.getYear());
            System.out.println(book.getBookName());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(book.getDescription() + "\n");

        }
    }

}
