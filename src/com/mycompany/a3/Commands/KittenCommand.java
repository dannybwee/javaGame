package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class KittenCommand extends Command {
	
    private static KittenCommand kittenCommand;
    private static GameWorld game;

    private KittenCommand(GameWorld game){
        super("New Kitten");
        this.game = game;
    }

    //ONLY ONE INSTANCE
    public static KittenCommand kitten(GameWorld game){
        if(kittenCommand == null)
        	return new KittenCommand(game);
        return kittenCommand;
    }

    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e) {
        game.KittenCat();
    }
}