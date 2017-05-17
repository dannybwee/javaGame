package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class GiveHelpCommand extends Command{
    
	private static GiveHelpCommand help;
    
    private GiveHelpCommand(){
        super("Help?");
    }
    
    //ONLY ONE INSTANCE
    public static GiveHelpCommand help(){
        if(help == null)
        	return new GiveHelpCommand();
        return help;
    }
    
    //ACTION PERFROMED
    @Override
    public void actionPerformed(ActionEvent ev){
        String Button = ""; 
        Button=Button.concat("A = Move net to a Cat\n");
        Button=Button.concat("C = Contract Net\n");
        Button=Button.concat("D = Move Net Down\n");
        Button=Button.concat("E = Expand Net\n");
        Button=Button.concat("F = Fight between Cat and Dog\n");
        Button=Button.concat("K = Cats collide and make a Kitten\n");
        Button=Button.concat("L = Move Net Left\n");
        Button=Button.concat("O = Move Net to a Dog\n");
        Button=Button.concat("R = Move Right\n");
        Button=Button.concat("S = Scoop Under Net\n");
        Button=Button.concat("T = Time Ticks\n");
        Button=Button.concat("U = Move Net Up\n");
        Button=Button.concat("X = Exit");
        Dialog.show("Help", Button, "Close", null);
    }
}