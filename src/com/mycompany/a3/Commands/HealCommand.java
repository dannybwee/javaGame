package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game.GameWorld;
import com.mycompany.a3.GameObjects.Dog;
import com.mycompany.a3.Interfaces.IIterator;
import com.mycompany.a3.Interfaces.ISelectable;

public class HealCommand extends Command {
	
	private GameWorld gw;
    private boolean enabled;
    private static HealCommand  heal;
	
	
	 private HealCommand(GameWorld gw){
	        super("Heal");
	        this.gw = gw;
	        enabled = true;
	    }
	
	 //ONLY ONE INSTANCE	
	 public static HealCommand heal(GameWorld gw){
	        if(heal == null)
	            return new HealCommand(gw);
	        return heal;
	    }
	 
	 //ACTION PERFROMED
	 //THIS checks to see if the instance of dog is selected. 
	 //It only works in pause.
	 @Override
	    public void actionPerformed(ActionEvent ev){
	        IIterator it = gw.iterator();
	        while(it.hasNext()){
	            Object x = it.getNext();
	            if(x instanceof ISelectable && x instanceof Dog ){
	                Dog dog = (Dog) x;
	                if(dog.isSelected()){
	                    gw.heal(dog);
	                }
	            }
	        }
	    }
}
