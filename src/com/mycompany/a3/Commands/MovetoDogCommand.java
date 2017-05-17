package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;

public class MovetoDogCommand extends Command {
	
	private static MovetoDogCommand moved;
	private GameWorld game;
    
    private MovetoDogCommand(GameWorld game){
        super("JumpToADog");
        this.game = game;
    }
    
    //ACTION PERFORMED
    public static MovetoDogCommand moveDog(GameWorld game){
        if(moved == null)
            moved = new MovetoDogCommand(game);
        return moved;
    }
    
    //ONLY ONE INSTANCE
    @Override
    public void actionPerformed(ActionEvent ev){
    	System.out.println("Moved to dog");
    	game.moveDog();
    }
}
