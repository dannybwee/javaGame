package com.mycompany.a3.Commands;


import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;


public class AboutCommand extends Command{

    private static AboutCommand aboutCommand;

    private AboutCommand(){
        super("About");
    }

    //ONLY ONE INSTANCE
    public static AboutCommand aboutCommand(){
        if(aboutCommand == null)
            return new AboutCommand();
        return aboutCommand;
    }

   //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e){
        Dialog.show( "About","Daniel Bui - CSC 133 - ASSIGNMENT 3", "Close", null);
    }
}