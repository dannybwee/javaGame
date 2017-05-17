package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class LeftCommand extends Command{

    private static LeftCommand leftCommand;
    private static GameWorld game;

    private LeftCommand(GameWorld game){
        super("Left");
        this.game = game;
    }

  //ONLY ONE INSTANCE
    public static LeftCommand left(GameWorld game){
        if(leftCommand == null)
            return new LeftCommand(game);
        return leftCommand;
    }

    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e) {
        game.moveLeft();
    }
}