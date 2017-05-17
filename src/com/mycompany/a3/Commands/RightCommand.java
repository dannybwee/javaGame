package com.mycompany.a3.Commands;

import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;
import com.codename1.ui.Command;

public class RightCommand extends Command {

    private static RightCommand rightCommand;
    private static GameWorld game;

    private RightCommand(GameWorld game){
        super("Right");
        this.game = game;
    }

    //ACTION PERFORMED
    public static RightCommand right (GameWorld game){
        if(rightCommand == null)
            rightCommand = new RightCommand(game);
        return rightCommand;
    }

    //ONLY ONE INSTANCE
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Net has moved right");
        game.moveRight();
    }
}