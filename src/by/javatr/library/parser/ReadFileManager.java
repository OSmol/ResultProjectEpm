package by.javatr.library.parser;

import by.javatr.library.exception.ReadFileException;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileManager {

    private static Gson gson = new Gson();

    public static List<String> readFile(File file) throws ReadFileException {

        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }
        } catch (FileNotFoundException ex) {
            throw new ReadFileException("File not found.");
        } catch (IOException e) {
            throw new ReadFileException("ReaFileException in read method.");
        }

        return list;
    }


}
