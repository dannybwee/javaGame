package com.mycompany.a3.Commands;

import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;
import com.codename1.ui.Command;

public class UpCommand extends Command{
	
    private static UpCommand upCommand;
    private GameWorld game;

    private UpCommand(GameWorld game){
        super("Up");
        this.game = game;
    }

    //ONLY ONE INSTANCE
    public static UpCommand up(GameWorld game){
        if(upCommand == null)
            return new UpCommand(game);
        return upCommand;
    }

    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent ev){
        game.moveUp();
    }
}