package by.javatr.library.validator;

public class UserValidator {

    public static boolean validateYear(int year) {

        String s = String.valueOf(year);
        return s.matches("\\d{1,4}$");
    }

    /**
    * login c ограничением 2-20 символов,
     * которыми могут быть буквы и цифры,
     * символ подчеркивания, дефис,
     * первый символ обязательно буква
     */
    public static boolean validateLogin(String login) {
        return login.matches("^[a-zA-Z][a-zA-Z0-9-_]{1,20}$");
    }

    /**
     * password с ограничением 6-18 символов,
     * которыми могут быть буквы и цифры,
     * символ подчеркивания, дефис,
     * первый символ обязательно буква
     */
    public static boolean validatePassword(String password) {

        return  password.matches("^[a-zA-Z][a-zA-Z0-9_-]{6,18}$");
    }

    /**
     * name с ограничением 2-25 символов,
     * которыми могут быть только буквы и
     * дефис, первый символ обязаткльно буква.
     */
    public static boolean validateName(String name){

        return name.matches("^([a-zA-Z-]|[а-яА-Я-]){2,25}$");
    }



}
