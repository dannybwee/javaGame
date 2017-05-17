package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;

public class QuitCommand extends Command{
    
    private static QuitCommand  quit;
    private GameWorld gw;
    
    private QuitCommand(){
        super("Quit");
    }
    
    //ACTION PERFORMED
    public static QuitCommand quit(){
        if(quit == null)
            return new QuitCommand();
        return quit;
    }
    
    //ONLY ONE INSTANCE
    @Override
    public void actionPerformed(ActionEvent ev){
        Boolean exit = Dialog.show("Exit", "Are you Sure?", "Yes", "No");
        if(exit){
            Display.getInstance().exitApplication();
        }
    }
}
