package by.javatr.library.runner;

import by.javatr.library.controller.Controller;
import by.javatr.library.scanner.DataScanner;
import by.javatr.library.util.Request;
import by.javatr.library.util.Response;

public class Runner {

    public static void main(String[] args) {

        boolean flag = false;
        Controller controller = new Controller();
        while (true) {

            System.out.println(controller.getMenu());
            int action = DataScanner.enterIntFromConsole();


            while (!flag) {
                Request request = new Request();
                Response response = controller.checkParameters(action);

                if (action == 5
                        && response.getParameters() != null
                        && response.getParameters().get("SIGN_OUT").equals("true")) {
                    flag = true;
                }

                String command = response.getCommandName();
                if (command != null) {
                    Request requestToRemove = new Request();
                    requestToRemove.addParameter("commandName", command);
                    Response responseInner = controller.executeTask(requestToRemove);
                    Printer.printExecutiveResponse(responseInner);
                }
                Printer.printRespond(response, request);


                response = controller.executeTask(request);

                Printer.printExecutiveResponse(response);

                if (response.getStatus()&&flag!=true) {
                    System.out.println(controller.getMenu());
                    action = DataScanner.enterIntFromConsole();

                }


            }
            flag = false;



        }
    }

}
