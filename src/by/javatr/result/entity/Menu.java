package by.javatr.result.entity;

public class Menu {

    int id;
    private String [] menuActions;

    public Menu(int i, MenuAction [] menuAction){
        this.id=i;
        setMenuAction(menuAction);
    }

    public int getId() {
        return id;
    }

    public String [] getMenuAction() {
        return menuActions;
    }

    public final void setMenuAction(MenuAction[] menuAction) {
        menuActions=new String [menuAction.length];
        for (int i = 0; i < menuAction.length; i++) {
            menuActions[i]=menuAction[i].toString();
        }
    }
}
