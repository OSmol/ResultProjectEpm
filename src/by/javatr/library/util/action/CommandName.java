package by.javatr.library.util.action;

public enum CommandName {

    SIGN_IN("Start") {
        @Override
        public boolean isUser() {
            return true;
        }
    }, REGISTRATION("Start") {
        @Override
        public boolean isUser() {
            return true;
        }
    }, ADD_BOOK("Admin") {
        @Override
        public boolean isUser() {
            return false;
        }
    }, FIND_BOOK ("User"){
        @Override
        public boolean isUser() {
            return true;
        }
    }, ADD_USER("Admin") {
        @Override
        public boolean isUser() {
            return false;
        }
    }, SIGN_OUT ("User"){
        @Override
        public boolean isUser() {
            return true;
        }
    }, GET_CATALOG("User") {
        @Override
        public boolean isUser() {
            return true;
        }
    }, GET_USERS ("Admin"){
        @Override
        public boolean isUser() {
            return false;
        }
    }, REMOVE_BOOK ("Admin"){
        @Override
        public boolean isUser() {
            return false;
        }
    }, REMOVE_USER("Admin") {
        @Override
        public boolean isUser() {
            return false;
        }
    }, WRONG_REQUEST("System"){
        @Override
        public boolean isUser() {
            return false;
        }
    };


    String TypeOfMenu;
    public abstract boolean isUser();

    CommandName(String type){
        this.TypeOfMenu=type;
    }

    public String getTypeOfMenu() {
        return TypeOfMenu;
    }
}
