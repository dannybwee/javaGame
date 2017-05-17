package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.Game;
 

public class PauseCommand extends Command{
    private Game g;
    private boolean enabled;
    private static PauseCommand  pause;
     

    
    private PauseCommand(Game g){
        super("Pause");
        this.g = g;
        enabled = true;
    }
     

    //ACTION PERFORMED
    public static PauseCommand pause(Game g){
        if(pause == null)
            return new PauseCommand(g);
        return pause;
    }


    //ONLY ONE INSTANCE
    //Changes pause and play button
    @Override
    public void actionPerformed(ActionEvent ev){
        if(enabled){
            g.removeKeys();
            g.setTimer(!enabled);
            g.PlayButton(!enabled);
        }else{
            g.setKeys();
            g.setTimer(!enabled);
            g.PlayButton(!enabled);
        }
        enabled = !enabled;
    }
}