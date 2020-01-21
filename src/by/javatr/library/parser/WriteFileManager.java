package by.javatr.library.parser;

import by.javatr.library.exception.FileParserException;
import com.google.gson.Gson;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class WriteFileManager {

    private static Gson gson = new Gson();

    public static void writeToFile(Serializable obj, File file, boolean append) throws FileParserException {

        try (FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(gson.toJson(obj));
            fileWriter.write("\n");
        } catch (IOException ex) {
            throw new FileParserException("FileParserException in write method.");
        }

    }

    public static void writeToFile(List list, File file) throws FileParserException {

        try (FileWriter fileWriter = new FileWriter(file)) {

            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                fileWriter.write(gson.toJson(iterator.next()));
                fileWriter.write("\n");
            }

        } catch (IOException ex) {
            throw new FileParserException("FileParserException in write method.");
        }

    }


}
