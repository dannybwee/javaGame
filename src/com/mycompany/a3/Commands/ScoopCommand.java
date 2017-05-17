package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;

public class ScoopCommand extends Command {
	
	private static ScoopCommand scoop;
	private GameWorld game;
    
    private ScoopCommand(GameWorld game){
        super("SCOOOOPED");
        this.game = game;
    }
    
    //ACTION PERFORMED
    public static ScoopCommand scoop(GameWorld game){
        if(scoop == null)
            scoop = new ScoopCommand(game);
        return scoop;
    }
    
    //ONLY ONE INSTANCE
    @Override
    public void actionPerformed(ActionEvent ev){
    	System.out.println("SCOOPED");
    	game.scoop();
    }
}
