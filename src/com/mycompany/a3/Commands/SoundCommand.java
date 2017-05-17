package com.mycompany.a3.Commands;

import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.SideMenuBar;

public class SoundCommand extends Command {
  
	private static SoundCommand soundCommand;
    private static GameWorld game;

    private SoundCommand(GameWorld game){
        super("Sound On/Off");
        this.game = game;
    }

    //ACTION PERFORMED
    public static SoundCommand sound(GameWorld game){
        if(soundCommand == null)
            return new SoundCommand(game);
        return soundCommand;
    }

    //ONLY ONE INSTANCE
    @Override
    public void actionPerformed(ActionEvent ev){
        if (((CheckBox)ev.getComponent()).isSelected())
            game.setSound(true);
        else
            game.setSound(false);
        SideMenuBar.closeCurrentMenu();
    }
}