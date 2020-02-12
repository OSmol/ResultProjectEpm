package by.javatr.library.dao.parser;

import by.javatr.library.dao.parser.exception.ReadFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileManager {


    public static List<String> readFile(File file) throws ReadFileException {

        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }
        } catch (FileNotFoundException ex) {
            throw new ReadFileException("File not found.",ex);
        } catch (IOException e) {
            throw new ReadFileException("ReaFileException in read method.",e);
        }

        return list;
    }


}
