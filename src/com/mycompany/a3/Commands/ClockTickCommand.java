package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class ClockTickCommand extends Command{
    
    private static ClockTickCommand  tick;
    private GameWorld gw;
    
    private ClockTickCommand(GameWorld gw){
        super("Tick");
        this.gw = gw;
    }
    
    //ONLY ONE INSTANCE
    public static ClockTickCommand ticked(GameWorld gw){
        if(tick == null)
            return new ClockTickCommand(gw);
        return tick;
    }
    
    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent ev){
    }
}
