package by.javatr.result.entity;

import java.util.ArrayList;
import java.util.List;

public enum AdminAction implements MenuAction {

    SIGNOUT, FINDBOOK, GETCATALOG, ADDBOOK, REMOVEBOOK;


    final int id=3;

    @Override
    public List<String> toStringArray() {
        List<String> actions=new ArrayList<>();
        AdminAction [] adminActions=AdminAction.values();
        for(int i=0;i<adminActions.length;i++){
            actions.add(adminActions[i].toString());
        }
        return actions;
    }
}
