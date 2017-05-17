package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;


public class ContractCommand extends Command{
    
	private static ContractCommand contractCommand;
    private GameWorld game;

    private ContractCommand(GameWorld game){
        super("Contract");
        this.game = game;
    }
   
    //ONLY ONE INSTANCE
    public static ContractCommand contract(GameWorld game){
        if(contractCommand == null)
            return new ContractCommand(game);
        return contractCommand;
    }

    //ACTION PERFORMED
    @Override
    public void actionPerformed(ActionEvent e) {
        game.contract();
    }

}