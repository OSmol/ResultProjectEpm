package by.javatr.result.runner;

import by.javatr.result.scanner.DataScanner;


public class Runner {

    public static void main(String[] args) {


       while(true) {
           Printer.printMenu(MenuResolver.getStartMenu());

           int action = DataScanner.enterIntFromConsole();
           MenuResolver.checkAction(action, null, MenuResolver.getStartMenu());
       }
    }

}
