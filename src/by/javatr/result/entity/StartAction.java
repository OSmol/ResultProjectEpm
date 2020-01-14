package by.javatr.result.entity;

import java.util.ArrayList;
import java.util.List;

public enum StartAction implements MenuAction {

   SIGNIN, REGISTRATION;

   final int id=1;

   @Override
   public List<String> toStringArray() {
      List<String> actions=new ArrayList<>();
      StartAction [] startActions=this.values();
      for(int i=0;i<startActions.length;i++){
         actions.add(startActions[i].toString());
      }
      return actions;
   }

}
