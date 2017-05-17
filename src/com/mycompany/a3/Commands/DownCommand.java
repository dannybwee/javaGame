package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class DownCommand extends Command{
   
	private static DownCommand downCommand;
    private GameWorld game;

    private DownCommand(GameWorld game){
        super("Down");
        this.game = game;
    }

    //ONLY ONE INSTANCE
    public static DownCommand down(GameWorld game){
        if(downCommand == null)
            return new DownCommand(game);
        return downCommand;
    }
    
    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e) {
        game.moveDown();
    }
}