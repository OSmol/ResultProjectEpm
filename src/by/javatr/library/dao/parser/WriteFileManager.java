package by.javatr.library.dao.parser;

import by.javatr.library.dao.parser.exception.WriteFileException;
import com.google.gson.Gson;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class WriteFileManager {


    public static void writeToFile(Serializable obj, File file, boolean append) throws WriteFileException {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(gson.toJson(obj));
            fileWriter.write("\n");
        } catch (IOException ex) {
            throw new WriteFileException("FileParserException in write method.",ex);
        }

    }

    public static void writeToFile(List<? extends Serializable> list, File file) throws WriteFileException {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(file)) {

            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                fileWriter.write(gson.toJson(iterator.next()));
                fileWriter.write("\n");
            }

        } catch (IOException ex) {
            throw new WriteFileException("FileParserException in write method.",ex);
        }

    }


}
