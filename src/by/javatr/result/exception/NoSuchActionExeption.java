package by.javatr.result.exception;

public class NoSuchActionExeption extends Exception{

    public NoSuchActionExeption() {
    }

    public NoSuchActionExeption(String message) {
        super(message);
    }

    public NoSuchActionExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchActionExeption(Throwable cause) {
        super(cause);
    }
}
