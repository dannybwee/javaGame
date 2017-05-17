package com.mycompany.a3;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.a3.Game.Game;


//Assignment 2
//Daniel Bui
//oh boy here we go. Again.
//Starter from Assignment1. No changes.

public class Starter {
//other methods
	private Form current;
	private Resources theme;
	

	public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme"); //Theme set to native
 
    }
	
	//Initializes the Dog Catcher Game
	
	public void start(){
		if (current !=null){
			current.show();
			return;
		}
		new Game();
	}

	public void stop() {
		current = Display.getInstance().getCurrent();
	}
	
	public void destroy() {
	}
}

