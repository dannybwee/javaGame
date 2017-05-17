package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class ExpandCommand extends Command {
   
	private static ExpandCommand expandCommand;
    private static GameWorld game;

    private ExpandCommand(GameWorld game){
        super("Expand");
        this.game = game;
    }

    //ONLY ONE INSTANCE	
    public static ExpandCommand expand(GameWorld game){
        if(expandCommand == null)
            return new ExpandCommand(game);
        return expandCommand;
    }

    //ACTION PERFORMED	
    @Override
    public void actionPerformed(ActionEvent e) {
        game.expand();
    }
}