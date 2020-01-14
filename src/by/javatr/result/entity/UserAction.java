package by.javatr.result.entity;


import java.util.ArrayList;
import java.util.List;

public enum UserAction implements MenuAction {

    SIGNOUT, FINDBOOK, GETCATALOG;


    final int id = 2;

    @Override
    public List<String> toStringArray() {
        List<String> actions = new ArrayList<>();
        UserAction[] userActions = this.values();
        for (int i = 0; i < userActions.length; i++) {
            actions.add(userActions[i].toString());
        }
        return actions;
    }

}
