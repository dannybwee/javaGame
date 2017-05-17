package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;

public class MoveToCatCommand extends Command{
   
    private static MoveToCatCommand  move;
    private GameWorld game;
    
    private MoveToCatCommand(GameWorld game){
        super("JumpToACat");
        this.game = game;
    }
    
    //ONLY ONE INSTANCE
    public static MoveToCatCommand moveCat(GameWorld game){
        if(move == null)
           return new MoveToCatCommand(game);
        return move;
    }
    
    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent ev){
    	game.moveCat();
    }
}
