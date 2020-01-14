package by.javatr.result.util;

import by.javatr.result.util.action.MenuAction;
import java.util.Arrays;


public class Menu {

    private int id;
    private String[] menuActions;

    public Menu(MenuAction[] menuAction) {
        this.id = Math.abs(this.hashCode()) + (int) (Math.random() * 150);
        setMenuAction(menuAction);
    }

    public int getId() {
        return id;
    }

    public String[] getMenuAction() {
        return menuActions.clone();
    }

    public final void setMenuAction(MenuAction[] menuAction) {
        menuActions = new String[menuAction.length];
        for (int i = 0; i < menuAction.length; i++) {
            menuActions[i] = menuAction[i].toString();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Menu menu = (Menu) obj;
        if (id != menu.id) return false;
        if (menuActions.length != menu.getMenuAction().length) return false;
        String[] actions = menu.getMenuAction();
        for (int i = 0; i < menuActions.length; i++) {
            if (actions[i] != menuActions[i]) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + id;
        if (menuActions == null) {
            result = result * prime;
        } else {
            for (int i = 0; i < menuActions.length; i++) {
                result = result * prime + menuActions[i].hashCode();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass() + "" + '@' +
                "id=" + id +
                ", menuActions=" + Arrays.toString(menuActions) +
                '}';
    }
}
