package by.javatr.library.runner;

import by.javatr.library.scanner.DataScanner;
import by.javatr.library.util.Request;
import by.javatr.library.util.Response;
import java.util.HashMap;
import java.util.Map;


public class Printer {


    public static void printRespond(Response response, Request request) {

        if (response.getStatus()) {
            HashMap<String, String> params=response.getParameters();
            String param;
            for (Map.Entry<String,String> entry :params.entrySet()) {
                System.out.println(entry.getKey() + ": ");
                param = DataScanner.enterStringFromConsole();
                request.addParameter(entry.getKey(), param);
            }
        }
    }

    public static void printExecutiveResponse(Response response) {

        System.out.println(response.getParameters().get("message"));
    }
}


