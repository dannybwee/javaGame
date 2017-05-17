package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class FightCommand extends Command{
	
    private static FightCommand fightCommand;
    private static GameWorld game;

    private FightCommand(GameWorld game){
        super("Fight");
        this.game = game;
    }

    //ONLY ONE INSTANCE	
    public static FightCommand fight(GameWorld game){
        if(fightCommand == null)
            return new FightCommand(game);
        return fightCommand;
    }

    
    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e) {
        game.fight();
    }
}