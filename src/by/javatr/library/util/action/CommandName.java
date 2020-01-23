package by.javatr.library.util.action;

public enum CommandName {

    SIGN_IN("Start"), REGISTRATION("Start"), ADD_BOOK("Admin"), FIND_BOOK("User"),
    ADD_USER("Admin"), SIGN_OUT("User"), GET_CATALOG("User"), GET_USERS("Admin"),
    REMOVE_BOOK("Admin"), REMOVE_USER("Admin"), WRONG_REQUEST("System");

    String TypeOfMenu;

    CommandName(String type) {
        this.TypeOfMenu = type;
    }

    public String getTypeOfMenu() {
        return TypeOfMenu;
    }
}
